import java.util.*;

public class project {

    static ArrayList<Integer> stats = new ArrayList<Integer>();
    static ArrayList<Integer> random = new ArrayList<Integer>();

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            
            System.out.println("What is your name?");
            String name = input.nextLine();

            System.out.println("Choose a weapon of your choise!");
            String weapon = input.nextLine();

            randomStats(name, weapon);
            story(name, weapon);
        }
    }

    /*Randomizes the playes stats */
    public static void randomStats(String name, String weapon) {

        /* character states */

        int health = (int) (Math.random() * 20) + 5;
        stats.add(health);

        System.out.println("\nCharacter name: " + name);
        System.out.println("" + name + "'s health: " + health + "\n");

        /* weapon states */

        int attack = (int) (Math.random() * 50) + 1;
        int critChance = (int) (Math.random() * 100) + 1;
        int critDamage = (int) (Math.random() * 100) + 1;

        stats.add(attack);

        stats.add(critChance);

        stats.add(critDamage);

        for (int i = 0; i <= 4; i++) {
            stats.add(0);
        }

        System.out.println("Weapon name: " + weapon);

        System.out.println("" + weapon + "'s attack: " + attack);

        System.out.println("" + weapon + "'s critChance: " + critChance);

        System.out.println("" + weapon + "'s critDamage: " + critDamage);
    }



    /*Checks whether the player hit crit or not */
    public static Boolean critOrNot(int crit) {
        return (int) (Math.random() * 100) + 1 <= crit;
    }



    /*Creates a randomized boss's stats */
    public static void Boss(int maxBosshp, int maxAttack, int maxMisschance) {

        int bosshp = (int) (Math.random() * maxBosshp) + 1;

        int bossattack = (int) (Math.random() * maxAttack) + 1;

        int misschance = (int) (Math.random() * maxMisschance) + 1;

        stats.set(4, bosshp);

        stats.set(5, bossattack);

        stats.set(6, misschance);

    }


    /*Sets the target value to hit the boss */
    public static void setTarget(int maxTarget) {
        stats.set(7, (int) (Math.random() * maxTarget) + 1);
    }



    /*Checks if the Boss missed his attack on the player */
    public static Boolean bossmiss() {
        return (int) (Math.random() * 100) + 1 <= stats.get(6);
    }



    /*Informs the user were the target value might be located and retunrs true if value == target */
    public static Boolean farorClose(int userGuess) {

        int target = stats.get(7);
        if (userGuess > target) {
            System.out.println("You missed the opponent it was too \"HIGH\"");
            return false;

        } else if (userGuess < target) {
            System.out.println("You missed the opponent it was too \"LOW\"");
            return false;

        } else {
            System.out.println("You hit the Boss!--Nice hit");
            return true;
        }
    }



    /*Runs until player or opponent are defetead,checks crit and other aspect of battle */
    public static Boolean battle(int playerHealth, int bossHealth, int maxTarget) {

        Boolean introduction = true;

        while (playerHealth > 0) {

            int damage;
            Scanner input = new Scanner(System.in);
            if (introduction) {
                System.out.println("\n ___________________________________________________________"
                        + "\n+                   ***NOTICE**                             +");
                System.out.println(
                        "| How the battle works is you need to input a number        |\n| if you manage to input a value equal to the boss target   |\n| it will result in a hit                                   |\n| otherwise the boss has a chance to proc a hit.            |");
                System.out.println(" ____________________________________________________________");
                introduction = false;
            }

            System.out.println("  \n(The range is 0-" + maxTarget + ")");
            int userGuess = input.nextInt();

            if (farorClose(userGuess) == true) {

                if (critOrNot(stats.get(2))) {

                    setTarget(maxTarget);
                    double cD = stats.get(3) / 100;
                    damage = (int) (stats.get(1) + (cD * stats.get(1)));
                    bossHealth -= damage;
                    System.out.println("crit : -" + damage);

                } else {

                    setTarget(maxTarget);
                    damage = stats.get(1);
                    bossHealth -= damage;
                    System.out.println("dmg: -" + damage);

                }
            } else if (bossmiss()) {
                System.out.println("The Boss Missed his attack!");

            } else {
                playerHealth -= stats.get(5);
            }

            if (playerHealth <= 0) {
                break;
            }
            if (bossHealth <= 0) {
                break;
            }
            String name = String.format("                 |Boss hp: %d|", bossHealth);
            String h = String.format("                 |Your hp: %d|", playerHealth);
            System.out.println("                 _____________");
            System.out.println(h);
            System.out.println(name);
            System.out.println("                 _____________");
        }
        if (playerHealth <= 0) {
            return false;
        }
        return true;
    }

    public static void spike(){

        System.out.println("                                                              ;                                                            ");
        System.out.println("                                                        `      i     .                                                      ");
        System.out.println("                                                       .;      }     \"                                                      ");
        System.out.println("                                                       '+      )    'I   ,                                                  ");
        System.out.println("                                                  '    ,(  .^  |.`..,>.  i.   .                                             ");
        System.out.println("                                                  ;    !f  .l ,t ; ._?   [.   :                                             ");
        System.out.println("                                              ... ~'  .?c.  } :| _.\"1{  .f.   >                                             ");
        System.out.println("                                              `   ]I. `{Y,  r ix.}.lv)  .v.   ?'                                            ");
        System.out.println("                                         '    ,'. |].^`)zi .n [v`t'<L)..'U.   )^                                            ");
        System.out.println("                                     `   '\"   :^'.f|.:Ixr- Iv./u\"x;-qf.\"^J'   r:     ^                                      ");
        System.out.println("                                    ^ . 'l  .:i;.jc iIun{ +n unIr!}Ln.>;C^ . z;    .l    \"                                 ");
        System.out.println("                              .     i I.'<   >?<.xQ.?<nn1 )n.cv(r]1ruI[iO; ' c:    ^_    >                                 ");
        System.out.println("                           .  `^.   ? ~`\"?  `i)[.rq\"1?nc(.rr'cn:x(/jv]j?q> !.X;  \".:)   .>.   .'                           ");
        System.out.println("                           '  `>.   ( -;,}  :]f/;rQ;/}nzt`zx:cY`nnjjXvz/U<.<:U;  l >j   .i    ,^                           ");
        System.out.println("                           ;  '}..  f ?>,). l(nf+rx+x/u/j^cx}YO;nvnnc?mXv[.1]X> `i {x   `i`   <\"                           ");
        System.out.println("                           i  ./\",  j'}-,|. !xxjuux[nczvu,uu((p[uvxvL)d1nf.}nc-.;i /r   +i\"   [l                           ");
        System.out.println("                `    `     -  .x<: .r\"{|ix. lXxjrzxrx|rjv>xczcdvccnr1/c~ux'[zuf ~! xr   |_,   (~.     .                    ");
        System.out.println("                >    >     }, .u):.\"jl/u[n\".lcvj'rvYr! tc)f~>CbI~fuY1nx|cX`(tnc.]!`Yx  'cf\"  ./[.      .                   ");
        System.out.println("               .> .  _.    (< 'xc,`lr-vv|x<^lucx`uXzn+ nvUr.?Lp}.xcnrzxvzc:)rxz'{l;cj  \"cm\"   jx      `'                   ");
        System.out.println("          ,.    + .^ +`    |{ `nQI;~xtrunx1:lt]r;:/uux.ncJr,1zOx,u1-jcu<(;]xnxc\"/iinn  iub\"  'nn      ~.   ^'              ");
        System.out.println("          \",    <''+ I\"  . j) `c0-_)uYjvcuxi>jcxjl(vnf'nuCn(|zr^1uU)nczn)?|x/rv;r>~rX:.jxk\"  <vx   .  x.  .>'              ");
        System.out.println("      I   'i    <!'t !i  I.xf \"Xj|(_uznuuur<)rzuU+jvu!.nnQvxnUu,rvUt/xzn}/vnYuv?u+]xX- 0rY\"  |cx   ; .O.   1'.             ");
        System.out.println("      -.  .[    l}.J l]  }.rx lzrur  )nv1..<Ux'>l1Xvc)`vnY` uYv+\"I+jrr|;{uYrncc(x?|rn`^Ovx\"  fcx   ] 'p.   |.;     .;      ");
        System.out.println("      <'  .u.'  It w.lt  n.ru:-crxx.'1xzj. -Qr< <fJu+.;unO\" zCu/l.?nuvu>(YYc,,zCvjvnY ;LYr: .rzr   f ^Q.   f +     'I      ");
        System.out.println("      l.  .U^I  lx`w.!x` L`zc~.1jjr`\"1rYr, ?Qjc rnwc<,invpI`uYnJ> |xxX)[jvYXt~X0zJxx'.>r}r; izXt `^/ ;X'  'r [    .^'.     ");
        System.out.println(".     :!   0I<  lxiZ.lx; C_Xvt /urj;<1xXx- (Or?.zxpvf;?xrql:xxxv?^fnvv'|vr`^ /zO,Iuzi,)jUn1'<cUt.>;1 /c'  !r`t     _'      ");
        System.out.println("_     ^{  .L-?  !r}X\"lx] c+lvt.1cjxj[nxzr( )OuX zxpr'~fxXY>lxjj`{lunzU\"uXf.  zcmI]rX)<cfXzL'iXXr._i}.Qv`  1r>|     n.       ");
        System.out.println("|     'j   C(|  -xfX1_rX'u?'cu'])rvUfrfnxt./Ozu'uxpc'-vrXu}|uUr:1_cu!`\"YXt...Xnq:{x?`-Zx_l?'-ccul1][^Ur\"  jx}).    Q.   . \"  ");
        System.out.println("n     .x'  Un/. jurucruU;j1>cc]furc1xvtuvu\")xI 'cvpz\"?fxvxXXvJx<t{zx-.~cXj^; ix0;rx]\"}dn{.t'f-cx,)x{Ivn^  xx/);   `U.     [  ");
        System.out.println("n,'i  .x\"..vnr, >zrXciu{!tnIuv[nnnY{fLu(ccinn[  u|zui}zuUxY}|jr}f/ux} :jzxi-.[nx{zzjIrmuv.v'xnvc_[c)rcz` .crc]-  `\"v   .  f  ");
        System.out.println("|+.|  .r~'\"Yuu<  ,vzz<'`!jvl\"j;vnvUxrZul`f?Xxz  v.jv{)ucUnX/|cjrxjjr{ .:crn) uur|?x>>zzx: n'cccYx(u)(XU' +vzY?]. <+x   ^ .x  ");
        System.out.println("{}.Y  'nj'_Ynv{. ,vYcJ.`]uc]`n:uu1-[rmz[.r(Yn(  v^xcv)u-cvzx(CuUxxXut. lcrtu Xuxr  ._uvu .r>Xr)}(nnfUuU'.ncXz)? ./nf. ., If   v");
        System.out.println("-t Y  ,cY\"Itnvj,`:vXv'.`nuzf^cixcx ]jmUz'nxccz .zixv.tv_ircxrCczxvvcc. ivu>x Xvrn `,{xvJ'.jucX'.xcnCurc' \"(vcu~ 'vUj^ <, [{   ");
        System.out.println("-x\"C\".?xz(+rncui_Iccv''^rnv1\"n)jXQ./xmQ:.ncnvr ^vxuX:fv] !uct{>uru+]u  -zUuX'vvnn.I:uuu|.>ruzU:\"vvv0-xu' !~Cuc> ;uXc!.t^ /]   ");
        System.out.println("-x+u}.:uc){xucx}j>cXn`i`xcv-;uufx` uuZ0;'uv?)..lxXvY>nu}.)cYv/`Xvn}!X. )cjlQ'nvvn.>;cvx+'xr-n` <nc[QXnf' ))Lxc> ~Ovz,.u` n+    ");
        System.out.println("?r/rX' cu)r.fvvzJ;Xcni[\"xvuf;uzj}^ vcUv!`vu}(` -xc|]^vvt .|)zzIjvn/_C..Xxc{LInn^r ?+uvxf.Xxjj .{nc]qXYr` r)Cxc~ rxxv^.x'ln~      ");
        System.out.println(")uX[n. Xvcj^fuvrQ`Xcnu}!xjn!-vUru! vczv~_cz/|I.unJ,.>vux  \"IU0 .+nv/L.;zxzfn-nv+x'{)uc1 .zrzr.^Xcvuc\"zr^ jYCcn~^0vxz.:r.(x>     ");
        System.out.println("rcUvr.'cvLrlju>.w`znnJ|?xr/~)cJxc} ccvv]?vzjt!`UrX!.1vuu, ;lYQ. nuYY0` _x/XvunYux^|XvX/`_XzXv` icnLv^crI`nqUzn~ivUxY )f'uj<    ");
        System.out.println("`I.ir]'_vin?Xc}.p+Xnv~<|xzx1.;1czf,zzcz|I.ruc- ;xf'.>vxz_ ;~Yn.'vvYZZ:.xnccuXnXJn:rzcu| ccYXc` .]rYj~zvi-vp!rr~[xzuc.XriYu]    ");
        System.out.println("   >jc   ;nvzzu'Y(crn/~YvYCj .UCUv!zccXx+ cruj'+rz'.]nnCf !cYn.  ,{Ynl:YuXvuz{.ux!ni~n|.~;tYc`.>1xu)-Xz:xzp!Yn1rrzzn'nrczzn    ");
        System.out.println("   ~nU. .'xX!:|.nczvnc-fXJUu^.XQUr( )vcx1,YvuX;nuX, {nrZ/'lXzr`  ,rzn{.{vXvzcf zn[v~[r/'<.cYv:.{Yvx/';..ccx/cvrcrI~j!u|`^:     ");
        System.out.println("  .1uYt  .nz?.r:cnJXnu]x'.Yc~ lJ}rx'|xzrn^Xvnz!UvU+ 1xvU`.<-zr^  icvu-.r?XcXnv1YYnx]Xuc^i.>Xc` xXcjf.1.?znjl{v-rn[unnxt.   ");
        System.out.println("  .;cuI  ,ncQ'r+cu!Inu1v^ LUf lu(jX.jtvxv'']vX{I|\": txzp+.|uYv[. _cuu, c(c1}xX(XCXx/XnU,-.unu\" z`nfn.x.Iuxr;.'xfvuznJuY    ");
        System.out.println("         'xz:.frXuf+crYxI^Q0J.irLnc'vnXuz,.[uzj+| > frXJi.nvXzx^ |vvu-.zru rxc^jQ{x1n-`-(.Jxr>.0,Yvz^|  1xr;  (r~!uuzvU`   ");
        System.out.println("         ^vc> tvXcY`ut|x_^|O_`+j0vz,un(ujl |cvu_f.1 nnvQ>'vnt;`\" tuuc/\"zvn'YuY;j0cnzv_ |U /xr\"\"wlccX;?  vnu> 'v( nuX'I     ");
        System.out.println("        .+vUn junX].uxcjn\")Q .[rQ<c,Xni:n+ ?+vu{x /,zu0w-,cx/`l\"`fuxxiIuXx.<c1,rmYvUn}.XZ.Xvu`+Ziv/'~?  vuX~ >u/;YuU.      ");
        System.out.println("         :ft~.cx1:..xjzvC<1U`.rx0.X~Yx)lu{ ]lcvcn'r;vucu]~cun;+:Ivn!. >uXf.'. ~xpi1)x|'Yw,zXn^|0}v/ /? .vn|, }n/`]v?       ");
        System.out.println("             ;XcU.  uruz/!(x>.Yvm,znUcJ!uf ](cXYn\"j,vnxnjjczX]}!]zn1..juYf;  .tnb`.jrj,uZ;rcnItruvr.z[ +uc^..nxf           ");
        System.out.println("             ^fXf\" .uxc\".^fx1'tz0[zccr-<nu'])nccc!r_cuUxc{jtvrf>/znj. /zzr<   xcp`:YuX!nZ.'vu>nxXcz\"z{'XvXI :Uuz           ");
        System.out.println("              ''  . cuv: ^uxf.!<jrcuz|;+nv>{}.`Yv(tvccUxc+.;ucv+j+n|.  ~vr/.  czx,;rzf1uO.)cu]vntc}In1 /ccI ;jcu'          ");
        System.out.println("                    vcY( ^vnc^l_jLcuXv_1uXtff'\"XCLr~fjUnz1 -nzX(r{xx   >crC~.!UXrl .;.cu0.XvXnuu!v;_xf  :'    :            ");
        System.out.println("                   .zuYn.,nvU}l1nxzccx(]nXjux::zCUr~.>Uuvt.uuzzjrcuX\"  >zxn1./Xnr]  ':YYx.IjvXvz{n;jxj        .            ");
        System.out.println("                   .YuI  luzYrl(vxXXvnU?{``vv+ 'Cur} I/nnr.cuUvurzvX-  ?zx.n. rurj   -XXu.  |zvXux>CxU                     ");
        System.out.println("                   'zuX  <x|\"'I(zx_|zrztt.:cu)  vwrj.i{nuu'vn1uux-xf'  xcc[0 .rvuc.  ^vuu.  t/vuxjtXuJ.                    ");
        System.out.println("                   <zvL: ~x{  <rXrt,YvYnn^_czc..cYrz'+tnvc+n >ncni )  .zuz?O.Iuccc   :rvx' 'f!..cr<~u>                     ");
        System.out.println("                   .,{'  ]nj  <rYnQ-YcXvn!|zUZ' zuuC>]xucXcc.YuJx~ t  IYjI'O +rvzu   >rvz^ `xl _zxt.`.                     ");
        System.out.println("                         /xXI -rYuYl^{nnn?.ixC .cucO}1vuu]`u'UuXr[.n .!Yx_`w.(j].x.  )ruz} ?j< xzuz.                       ");
        System.out.println("                         xvUx {jXU!'''nnxj. _O. vx<[,rvn+^`n'.:xx1'r. |Yjc^m.nr]^x   vxz]..jx-.'}x\".                      "); 
        System.out.println("                         lzx:.fjv'.  .uuvC^ -Z.,cx~fIncu1 ,r\" .xxtlu,.(YjulO.ur(ir .,zr~  .vr]                            "); 
        System.out.println("                         .`. 'UuC;   .nxXj^']x.(czvt-nccn Ir< 'vnU)x!^)nr1/n~vnU}r  +Xun. iXuu                            "); 
        System.out.println("                             `ucC>   .rv>.  [r:rYX0rtxzcf'_r) \"xuJnr+!tzrxXx~nY|jn..xcvL.'/cvL`                        ");    
        System.out.println("                             .^-'    \"xn<   (r? ?}iccr{r}./nx \"r_^fx[]nznJcx,f:.rn^.\"]}\".. <);.                      ");      
        System.out.println("                                     >xct   jxr.  +vLx}/)`UcY.Ix''zxffvvuJcx)r .vu;                               ");         
        System.out.println("                                     /rzL^ 'XxY.  1cQr/jflXXU,}n^{XvUJc)})cuLn'lcni                         ");               
        System.out.println("                                     (rc-. IznL, .rrcuUux`?Y1'xx:,rcjpx[ UccUn^fvu)                      ");                  
        System.out.println("                                     fxc,  ^XuY- 'nrvcJzxi\"z+ cxl.'l`bn).,xxcx:ucXr                   ");                     
        System.out.println("                                     vxz-  'zr'  Ixuv/lcr},v[.cr_  ',hx|.  .uxI.]_.                ");                        
        System.out.println("                                     zuYf  \\lfnu;_znvIuj,zrn. .!kvt   !zn]                 ");                           
        System.out.println("                                     +v/`  ;nu'. ?juu+tvcCixxfcv0\" .~CvY.  Yvcz.             ");                              
        System.out.println("                                     ...   inu!  jjvcx^nc}+xn'nc?' .)rzC~  [czr.          ");                                 
        System.out.println("                                           )vcc  ujcUL\" . ]rn      ./rc!    ',         ");                                    
        System.out.println("                                           zvXL' vjcj^.  .njv;     .nrf..           ");                                       
        System.out.println("                                          .'t}.. crX^.   ,JrXx     ,Yjv..        ");                                          
        System.out.println("                                            .   .XnU!    .XxU>     +XuJ;      ");                                             
        System.out.println("                                                ^XcJ-    \"zx,      {XvC}   ");                                                
        System.out.println("                                                 \"j!.    ;vxi      .]z<.");                                                   
        System.out.println("                                                         >vr{        ");                                                     
        System.out.println("                                                         tcuY     ");                                                         
        System.out.println("                                                        .zczL  ");                                                            
        System.out.println("                                                        .^tv:. ");   
    }



    /*Prints win */
    public static void win(){

        System.out.println("    ___                    ___    __________________       __      __     ___               ");
        System.out.println("    \\ \\\\                  / //    |_______   ______|\\     |  \\\\    | |\\   | |\\             ");
        System.out.println("     \\ \\\\       _        / //      \\_____|  |_______\\|    |   \\\\   | ||   | ||          "); 
        System.out.println("      \\ \\\\     /\\\\      / //             |  ||            | |\\ \\\\  | ||   | ||             ");
        System.out.println("       \\ \\\\   /  \\\\    / //              |  ||            | | \\ \\\\ | ||   | ||                ");
        System.out.println("        \\ \\\\ / /\\ \\\\  / //               |  ||            | | |\\ \\\\| ||   |_||            ");
        System.out.println("         \\ \\/ // \\ \\\\/ //                |  ||            | | | \\ \\| ||   \\_\\|             ");
        System.out.println("          \\  //    \\  //          _______|  ||_____       | | |  \\   ||    _             ");
        System.out.println("           \\//      \\//          |________________|\\      |_| |   \\__||   |_|\\            ");
        System.out.println("                                 \\________________\\|       \\_\\|    \\_\\|   \\_\\|             ");
    }

    /*Prints grave */
    public static void death(String name){

        System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@⠏⣩⣉⠙⠻⢿@@@@@@@@@@@");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@⡿⢉⣛⠛⠿⢿⡟⣰@⢻@⡆⠀⠈@@@@@@@@@@");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@⡟⢠⠟@@⢶⣆⣰@@⣦⠹⠀⠀⣴@@@@@@@@@@");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@⣟⠀⠿⣧⣌⢻⣧⢣⠻⢧⢣⢻⡳⡀⣤⣉⡛⠻⢿@@@@@@@");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@⣷⣦⣤⣉⡛⢫⣆⢣⠣⠡⠣⠱⡑⡜⢿⠏⠀⠀⣸@@@@@@");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@⠀⣾⣎⢆⠃⠁⠁⠳⠘⡌⠌⠐⠀⣰@@@@@@@");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@⠿⠿⠿⠿⠿⠿⠿⢿@@@@@@@⠃⣸@@⣯⠀⠀⢠⣷⣶⣤⣀⣁⣰@@@@@@@@");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@⡇⠀⣤⣶⣶⣶⣶⣶⣶⣶⣶⣦⣄⣈⡉⠉⠙⠋⠠@@@⠁⡘⢀@@@@@@@@@@@@@@@");
        System.out.println("@@@@@@@@@@@@@@@@@@@⡿⠛⠃⠘⠿⠠⢼@@@@@@@@@@@⣦⣤⣀⡀⠀⠀⠀⠀⣾@@@@@@@@@@@@@@@");
        System.out.println("@@@@@@@@@@@@@@@@@@⡿⠀⣾@@⣷⣀⠾@@@@@@@@@@@@@@@⣶⣤⡈⠀⢄⡉⠛⠿@@@@@@@@@@@@");
        System.out.println("@@@@@@@@@@@@@@@@@⡿⠃⣾@@@@@⣶@@@@@@@@@@@@@@@@@@⣶⠀⠙⢶⣤⡈⠙⠻@@@@@@@@@");
        System.out.println("@@@@@@@@@@@@@@@@@⠃⣼@@@@@@@@@@@@@@@@@@@@@@@⠿⠿⠋⣴⣆⠀⠐⡦⣅⠀⢈⢻@@@@@@@");
        System.out.println("@@@@@@@@@@@@@@@@⠃⣼@@@@@@@@@@@@@@@@@@@@@@@@⣾@⡇@@⡈⠀⠀⠠⡠⠀⠁⠹@@@@@@");
        System.out.println("@@@@@@@@@@@@@@@⠇⠀@@@@⡟⠛⠛⢿@@@@@@@@@@@@@@@@@@@⣤⣾@⡟⢠⡱⣄⠈⠪⣃⡀⢹@@@@@");
        System.out.println("@@@@@@@@@@@@@@⠏⢀⣼@@@⡿⠁⠁⠀⠀⠙@@@⡟⠻⠿⢿@@@⠿⢿@@@@@@@@@⠃⣼⣷⣬⠳⡄⢌⠃⠘@@@@@");
        System.out.println("@@@@@@@@@@@@@⡿⠀@@@@⡿⠁⠂@@⠀⠀@@⡿⢀⡟⠆⣸@@⠃⠐⡀⠈⠙⢿@@@@@⡟⠀@@⡯⡳⣌⠢⠀⢠@@@@@");
        System.out.println("@@@@@@@@@@@@@⠃⣼@@@⡿⠁⡶@⠀⠀⣀⣴@@⠃⣸⠤⢀@@⠃⣼@@⠘⠂⠈⢻@@@@⠇⢈⢻@⣷⣌⢮⠁⠀⠍⣹@@@@");
        System.out.println("@@@@@@@@@@@@⠏⣸@@@⡿⢡⡿⢠⠀⡆⠈@@@⡟⢰⠀⣼@⠇⣸@@⠀⠰⠓⠁⣼@@@⡿⠀⡻⣦⡻@⠿⠃⡀⠠⠀⢸@@@@");
        System.out.println("@@@@@@@@@@@⡟⢠@@@@⡃⠸⢁@⠀⢏⠀@@@⢃⠃⣼@⡿⢰ ⠀⢠⣤⣤⣴@@@@@⡇⣸@⣌⠓⠁⠄⠀⠀⠀⠀⢸@@@@");
        System.out.println("@@@@@@@@@@@⠃@@@@@@⣷⣾@⣤⣀⣀@@⣇⡈⠃@@ ⠁⠟ @@@@@@@@@@⡟⢠⣏⠟⠁⠀⠀⣤⡘⢧⡙⠂⢸@@@@");
        System.out.println("@@@@@@@@@@⡇⢸@@@@@@@@@@@@@@@@@@@⣴⣤⣀@@@@@@@⡿⠁⢸⠁⠀⠀⣶⠿⣮⡻⣦⣙⠀⣾@@@@");
        System.out.println("@@@@@@@@@@⠀⢸@@@@@@@@@@@@@@@@@@@@@@@@@@@@@⠛⢁⣴⠄⢤⡄⢸@⣎⠳⡈⠻⣎⡛⢰@@@@@");
        System.out.println("@@@@@@@@@⡏⠀⢸@@@@@@@@@@@@@@@@@@@@@@@@@⠟⠀⣫@⢠⣦⡑⠀⠻⣎⠣⡙⢦⡙⠃⢸@@@@@");
        System.out.println("@@@@@@@@⡟⢠⡀⠸@@@@⠿⠿⢿@@@@@@@@@@@@@@@@@@@⠻⣟⣠⢿@⡏⠘⠿⡳⣄⠀⢘⠳⣜⢶⣍⠀@@@@@@");
        System.out.println("@@@@@@@@⠃⣼⣧⣀⣉⠉⢰⣶⣶⣶⣾@@@@@@@@@@@@@@@@@@@⣧⡙⢿⣷⡝⠃⣾⣷⡙⢮⠀⠘⢷⣌⠳⡍⢰@@@@@@");
        System.out.println("@@@@@@@⠏⣸⣷⣝⢿@⡄⠨@@@@@@@@@@@@@@@@@@@@@@⣏⠻@⣦⠉⠃⠠⣽@⠻⣆⠢⠀⠠⡘⢷⠆⣸@@@@@@");
        System.out.println("@@@@@@⡏⢠⠻@@⣷⣝⢧⣄⣹@@@@@@@@@@@@@@@@@@@@@⡿⣷⣌⠋⢠⡆⠀⡌⠻⠑⠌⠃⠀⢷⣌⠲⢀@@@@@@@");
        System.out.println("@@@@@⡟⢀⣾⣷⣝⠻@⠿@@@@⡻⢿@@@@@@@@@@@@@@@@@⡝⢿⣬⡻⣇⠈⠐⠘⣧⡐⠄⠀⠠⠸⣦⡻⠇⢸@@@@@@@");
        System.out.println("@@@@@⠁⣼@@@⣷⣌⠳⣌⡻⢷⣝⢿⣦⣝⠻@@@@@@@@@@@⣌⠻@@⣦⡙⢷⠀⠀⢠⡘⢏⠻⣄⠀⡐⠔⢦⡙⠀⣾@@@@@@@");
        System.out.println("⡿⠟⠛⠛⠃⠰⠿⠛⠛⠛⠛⠿⣷⣾@⠾⠙⣓⣉⣉⣁⠙⠛⠻@⡿@@@@@@@@⡳⣮⣻@@⠖⠀⢀⣾@⠪⡳⣌⢷⣌⠢⡒⡅⢠@@@@@@@@");
        System.out.println("⣶⣾@⠿⠏⠐⠿⢿@⡟⣠⣶⣶⣶⣀⠘@@@@@@⡆⢳⣌⣻⣮⡙⢿⠿⢋⣩⣭⣄⣉⠊⠻⢾@⠀⡀⣶⣌⠫⠣⡑⢌⠢⡙⣧⡙⠀⠼⠿⠿⠿@@@@@");
        System.out.println("@@⣶@@@@⣦⣈⣳@@@⣛⣩⣤⣤⣈⡻⠟⣩⣤⣤⣤⣄⠉⢠⣶⣶⣦⣤⣈⣙@@@⠦⢀⣊⣀⡁⠙⠽⢷⡔⢈⣂⣁⡈⠂⠛⠠⠾⢿@⣶⣤⣬⠽⠿⠿");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@⣥⣼@@@@@⣦⣄⣴@@@@@⣀⣴⣶⣄⣈⣛⡡⡶⢶⣶⣶");

    }

    /*Prints Door */
    public static void printDoor() {

        System.out.println("     ______");
        System.out.println("  ,-' ;  ! `-.");
        System.out.println(" / :  !  :  . \\");
        System.out.println("|_ ;   __:  ;  |");
        System.out.println(")| .  :)(.  !  |");
        System.out.println("|\"    (##)  _  |");
        System.out.println("|  :  ;`'  (_) (");
        System.out.println("|  :  :  .     |");
        System.out.println(")_ !  ,  ;  ;  |");
        System.out.println("|| .  .  :  :  |");
        System.out.println("|\" .  |  :  .  |");
        System.out.println("|mt-2_;----.___|");
    }


    /*Prints Bats */
    public static void printBat(int bossHealth, int playerHealth) {

        System.out.println("\n     =/\\                 /\\=      ");
        System.out.println("     / \\\'._   (\\_/)   _.\'/ \\");
        System.out.println("    / .\'\'._\'--(o.o)--\'_.\'\'. \\");
        System.out.println("   /.\' _/ |`\'=/ \" \\=\'`| \\_ `.\\");
        System.out.println("  /` .\' `\\;-,\'\\___/\',-;/` \'. \'\\");
        System.out.println(" /.-\' jgs   `\\(-V-)/`       `-.\\");
        System.out.println("\n+++++++++++++++++++++++++++++++++++++++");
        System.out.println("+        Boss Health:" + bossHealth+"               +");
        System.out.println("+        Boss Damage:" + stats.get(5)+"                +");
        System.out.println("+        Boss missing chance:"+stats.get(7)+"       +");
        System.out.println("+++++++++++++++++++++++++++++++++++++++");

    }

        /*Prints the image of the Boss */
    public static void lastBoss(int bossHealth, int bossAttack) {

        System.out.println("                      ( ( ) )@@      /    ^             ^                  `'.");
        System.out.println("                    ))  ( @@ @ )    /      ^            ^                     `'.");
        System.out.println("                    ( ( @@@@@(@    /       |\\_/|,       ^                        `'.");
        System.out.println("                    )  )@@@(@@@   /      _/~/~/~|C      ^                           `'.");
        System.out.println("                    ((@@@(@@@@@( /     _(@)~(@)~/\\C     ^                              `'.");
        System.out.println("                    ))@@@(@@)@@ /     /~/~/~/~/`\\~`C    ^             __.__               `'.");
        System.out.println("                    )@@@@(@@)@@@(     (o~/~o)^,) \\~ \\C  ^          .' -_'-'\\\"...             `.");
        System.out.println("                    ( (@@@)@@@(@@@@@@_~^~^~,-/\\~ \\~ \\C/ ^        /`-~^,-~-`_~-^`;_             `.");
        System.out.println("                      @ )@@@(@@@@@@@    \\^^^/  (`^\\.~^ C^.,  /~^~^~^/_^-_`~-`~-~^\\- /`'-./`'-.   ;");
        System.out.println("                       (@ (@@@@(@@       `''  (( ~  .` .,~^~^-`-^~`/'^`-~ _`~-`_^-~\\          ^^\"");
        System.out.println("                           @jgs@             (((` ~ .-~-\\ ~`-_~`-/_-`~ `- ~-_- `~`;");
        System.out.println("                          /                 /~((((` . ~-~\\` `  ~ |:`-_-~_~`  ~ _`-`;");
        System.out.println("                         /                 /~-((((((`.\\-~-\\ ~`-`~^\\- ^_-~ ~` -_~-_`~`;");
        System.out.println("                        /                 /-~-/(((((((`\\~-~\\~`^-`~`\\ -~`~\\-^ -_~-_`~-`;");
        System.out.println("                       /                 /~-~/  `((((((|-~-|((`.-~.`Y`_,~`\\ `,- ~-_`~-`;");
        System.out.println("                      /              ___/-~-/     `\"\"\"\"|~-~|\"''    /~-^ .'    `:~`-_`~-~`;");
        System.out.println("                     /         _____/  /~-~/           |-~-|      /-~-~.`      `:~^`-_`^-:");
        System.out.println("                    /    _____/        ((((            ((((      (((((`           `:~^-_~-`;");
        System.out.println("                   \\___/                                                          `:_^-~`;");
        System.out.println("                                                                                    `:~-^`:");
        System.out.println("                                                                                  ,`~-~`,`");
        System.out.println("                   +++++++++++++++++++++++++                                     ,\"`~.,'");
        System.out.println("                   + Health:"+bossHealth+"             +                                ,\"-`,\"`");
        System.out.println("                   + Attack:"+bossAttack+"             +                            ,\"_`,\"");
        System.out.println("                   +++++++++++++++++++++++++                            , \",\"`");
        System.out.println("                                                                        ;~-~_~~;");

    }
    

    /*The core of the program */
    public static Boolean story(String name, String weapon) {

        try (Scanner input = new Scanner(System.in)) {
            System.out.println(
                    "\n***You find your self in the middle of a long hallway which looks darker, the further it goes!*** ");

            System.out.println("***You hear something approching closer and closer***");

            System.out.println("||| Choose: Run or stay |||");

            String answer = input.nextLine().toUpperCase();

            if (answer.equals("RUN")) {

                System.out.println("\n***" + name
                        + " run's without holding back!\n***You now enter a damp cave with little to no light.***\n***You hear noses all around!***");

                System.out.println(
                        "***Bats stops your path and blocks your escape route you have no option but to fight!***");

                Boss(50, 3, 100);

                int bossHealth = stats.get(4);
                int playerHealth = stats.get(0);

                int maxTarget = 50;
                setTarget(50);
                printBat(bossHealth, playerHealth);

                if (battle(playerHealth, bossHealth, maxTarget)) {
                    System.out.println("You have Defeated all the Bats!");
                    System.out.println(
                     "There are three Paths you can take, but your guts tell you two of which, will lead to your death!");

                    int c1 = (int)(Math.random()*3)+1;
                    int c3 = 0;
                    int c2 = 0;

                    if (c1 != 1 && c1 != 2){
                        c3 = 1;
                        c2 = 2;
                    }else if (c1!= 3 && c1 != 2){
                        c3 = 3;
                        c2 = 2;
                    }else{
                        c2 = 2;
                        c3 = 3;
                    }
                    Boolean finished = true;

                    while (finished) {

                        int answer2 = input.nextInt();
                        if (c1 == answer2) {

                            maxTarget = 600;
                            Boss(1,99999999,10);
                            setTarget(maxTarget);
                            System.out.println("\n***When you set foot in the cave, the temperature went up and the path behind closed***\n***You could see a giant shadow smilar to dragon sleeping***\n***There is no way out but, but there is a chance you can kill the dragon***\n***You need to find his weak spot you have only (1) try***");
                            lastBoss(stats.get(4),stats.get(5));

                            if (battle(playerHealth, bossHealth, maxTarget)){
                                System.out.println("\n***You manged to kill the drgon, which cause a hidden path to open***\n***Curiosity caused you to walk in, closer you got the brighter the room seemd");
                                win();

                            }else{
                                System.out.print("\n***You Hit the wrong spot now you face the wrath of the dragon***\n");
                                death(name);
                                return false;
                            }
                        

                        } else if (c2 == answer2) {

                            System.out.println("**After a long walk through the cave, you come infront of a door**");
                            printDoor();
                            System.out.println("***This door has two button, and you decide to press one***");

                            int answer3 = input.nextInt();
                            if (answer3 == (int)(Math.random()*2)+1){
                                win();

                            }else{
                                death(name);
                            }

                        } else if (c3 == answer2) {

                            System.out.println("***You walked and walked but evetualty fell into a spike pit!***");
                            spike();

                        } else {

                            System.out.println("Wrong Input!");

                        }
                    }
                } else {
                    death(name);
                    return false;
                }
            

            }else if (answer.equals("STAY")){

                

            }else{

                System.out.println("Invalid input so you die");
                death(name);
            }
            
            
        }

        return true;
    }
}