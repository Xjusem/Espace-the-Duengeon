import java.util.*;

public class project {

    static ArrayList<Integer> stats = new ArrayList<Integer>();

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


    /*Sets the target value in the list */
    public static void setTarget(int maxTarget) {
        stats.set(7, (int) (Math.random() * maxTarget) + 1);
    }



    /*Checks if the Boss missed his attack on the player */
    public static Boolean bossmiss() {
        return (int) (Math.random() * 100) + 1 <= stats.get(6);
    }



    /*Informs the user where the target value might be located and retunrs true if value == target */
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

    public static void drops(){

        int possDrop = (int)(Math.random()*4)+1 ;

        System.out.println("|||  The boss droped the following loot |||");

        if (possDrop == 1){

            System.out.println("... .. ....... 8@SSXS@.:........... .. .");
            System.out.println(". ........: . :8;t;8 :   ...:.. . ... ..");
            System.out.println("... ........: @8888@@%88 ......... .... ");
            System.out.println(". ...... ....: ;;Xt@8.t........ ... . ..");
            System.out.println("... .. ...:..: S.X.8X:%;:. ..... .......");
            System.out.println(". .. ..... ..: % 8 8X:S.......... . . ..");
            System.out.println("..... .......: % 8.8X:S;...... ....... .");
            System.out.println(". . .. . :....;8 X.8X.S8....:.. . . ....");
            System.out.println("............:.X.t.:::8  8@.......... . .");
            System.out.println(". . . ....  8888@%8888X@;%X%... . ......");
            System.out.println(".........:t8:@t88@X@S@t;;%8. ..... . . .");
            System.out.println(". ......:  ;:;@@8%%%%S;:t:;@X .. ...... ");
            System.out.println("......... @8%.;:.:t;t;:;;.:%X..... . ...");
            System.out.println(".........: @%;:;;;t;;:t;:XXX .... ... ..");
            System.out.println(". ........:8%8 .8%.. ..:t%;;... ... .. .");
            System.out.println(".............:8S%88888@ ;:.:..... ......");
            System.out.println(".......... |   +10 Health   |.. .... . ."); 

            stats.set(0,stats.get(0)+10);
            
        }else if (possDrop == 2){

            System.out.println("....'..''.''.................................................................");
            System.out.println("........'.'''................................................................");
            System.out.println(".....'''..'','''.............................................................");
            System.out.println(".....';,'..',;::,'..''.......................................................");
            System.out.println("......';:;'..';::;,,,,'''......'.............................................");
            System.out.println(".....'.',:cc:,,;:coolll:'''..................................................");
            System.out.println(".........',::,;codxddooc,''.'................................................");
            System.out.println("...'......',,,:cc::cclc:::::,................................................");
            System.out.println(".......'..',;,;:c::;;::::ccc;'....'..........................................");
            System.out.println(".........'',:,..''''..'',::;'...'............................................");
            System.out.println("........''.,::'.,;,,,,;;cxd,..'....'.........................................");
            System.out.println("...........';:;;;;:clodkO00o,.'.'..'.........................................");
            System.out.println("...........',;,,;coddxxkkO00d:'..............................................");
            System.out.println("............'',;;;;cllllodxkOkl,.'...........................................");
            System.out.println("............'.',,,,;;;;;::clooo;'..'.........................................");
            System.out.println("............'.....'',codddxxxkOxc'.'.....''..................................");
            System.out.println("..................'..;okOkkkkOOOko,'..'......................................");
            System.out.println("..................'..':dkkkxkOOOOOx:'....''..................................");
            System.out.println("..................''',;okkkkxkO00OOOd;'......................................");
            System.out.println("...................',,;oxxkkxxkO00000Ooccc:,'........''......................");
            System.out.println("....................,;',:llooooodxxxxkOkkxo;'.....''......'..................");
            System.out.println("....................',,;;;::::::::cllodddddol:,''............................");
            System.out.println("......................',,cdddxddoodddxk000Okxolc:;,'...''....................");
            System.out.println("......................'..:xkkOkxddoooodxkO0Okdollllc:;,''...''...............");
            System.out.println("...................'..'.;dkO0OkxdollllodxOKKK0kdolloodolc:;,''''.............");
            System.out.println("....................'...:dxxolldxxxdoolccc:;;;;;;;;:::::cccloodxxlx0l........");
            System.out.println(".....................'.,lolloxkkkkxddolcccc::::::::::::cccllodxkkdkOc........");
            System.out.println("...................'..';ccokO00Okkkxxddoollllccccccc:cccllodxxxdooOk;..'.....");
            System.out.println(".....................';clx0XK000OOkkkxxdddooolllllllllloolodkxlcccxd'.''.....");
            System.out.println("....................':odkKXXXKK00OOOkkxxxxxddddddoooodddocccccclcco:.........");
            System.out.println(".....................,lkO0KKXXKKK00OOOkkkkkxxxxxxxxxxxxxdlc:;:cc;c:'.........");
            System.out.println("......................';okO00KKXXKK000OOOOkkkkkkkkkkkkkdl:;'',::::'.'........");
            System.out.println("........................';lxO00KKXXKKK000OOOOOOOOOOOkxol::;;:;cl:,'..........");
            System.out.println("...........................,cokOO000KKKKKK00OOOOOOkdc:;;;:;cocddc,.'.........");
            System.out.println(".............................';coxOOO00KKKK00000Odc:::;;;:;:dxdo:'...........");
            System.out.println("......| +20 DMG     |............';:ldxOOOOO0OOOko:;;,'';cloodxo:'.'..........");
            System.out.println("...............................''...',:cllodxxxolc;,''',:cllc:,'.............");
            System.out.println("..........................................'',,,,;;::;;;;;;;,'''..............");
            System.out.println(".............................................''.....''''''...................");
            
            stats.set(1,stats.get(1)+20);

        }else if (possDrop == 3){

            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMWNNWMMMMMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMN0KX0XMMMMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMNKOkXW0kXMMMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMXxodkKNXkxKWMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMWKkddxO0XNKkk0NMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMNxlodxkkOOkxodXMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMW0o::::;;;::cOWMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMNkllolllooodKMMM| +25 CC  |MMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMWOddxxxdxxdkNMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMNOdxxxxdxxdkXMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMWKOkoloooooooodkOONMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMNOccdxdooooxO0KK0olkNMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMN0xl:ck0KXNWNNXKOdxkOOXMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMW0olodkKXNNWWNNXOxkOxkNMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMNx;,;:cldkkxdddoolodKMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMXo;,'',:ddllllllclOWMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMWO:;,'',ldollolccdXMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMXo:;'.':dolloc:lOWMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMWk::'..;oolooc:dXMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMM0lc;,.'locll:ckWMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMKoccc'.cl:ll:cOWMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMXo:od;..,':o::OMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMXo:x0c....cxc:0MMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMXl;kNOc::ckOol0MMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMM0::kXX0kxxOKxoOWMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMNd;o0X0doooxKkoxXMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMWO::k0kdooox0XOddONMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMKc;lOkoooooONMXxddOWMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMXo;ckOdoooookXWNkdddKMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMNx;:dOkoooodddO00kdddxXMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMWk:;okOdooodddddddxddxdxXMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMWOc;lxkkdddddxxdxOKKkddxokNMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMW0l;cdxkxdxxxxkkkOXWWKkdxxokNMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMW0l::lxkxxxkkOO0000XWWNKkkkxoOWMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMW0o::lxxxxxkO0000000KNWWX0OOOdlOWMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMWKo:coxxxxkOO000000000XNNNXO0KOolOWMMMMMMMMMMM");
            System.out.println("MMMMMMMMMKocdkkkxxkOOOOO0000000KNNNXKO0Kxll0WMMMMMMMMMM");
            System.out.println("MMMMMMMWKdokOOkxxkO00000K0KKKK0KNNNNX0kOK0do0WMMMMMMMMM");
            System.out.println("MMMMMMW0dxOOkkkxk0KKXXXXXXXXXNXXNNNNX0OkkKKxoONMMMMMMMM");
            System.out.println("MMMMMNkdkOkkkOOO0KKKXXXXXXXXXXXKXXXXXX0kkk0KkxkXWMMMMMM");
            System.out.println("MMMMXxx0KOO00000000000000000000O0XXXXXK0kkOKXKkkKWMMMMM");
            System.out.println("MMWKkOKKOO000000OkOO00KKKKKKKK000KXXKKXX0kxkKWNKOKWMMMM");
            System.out.println("MWKkKN0kkOOOOkxdddddxO000000000OOOKXXNWWWXOxxONWKk0WMMM");
            System.out.println("MKOKWNKOO00Okxxooxxdd00OO0OxxO0kkO0XWMMWMWNXKO0NWKx0WMM");
            System.out.println("NO0NNNNXKKOOO00kddkOkO0000OkxddodkOKWMMMWMMWWWNNWNOxKMM");
            System.out.println("0xKNNNXXXKK0KKK000OO0KKXXKK0OxdxdxOKNWMMMMMWWWWWWNKxkNM");
            System.out.println("kxKNNNXXKKKKKKKKKK0OOKXXXXXXXK0OOKKKKNWMWWWWWWWNNKxoxXM");
            System.out.println("kox0XXNXXKKKKKKKKKK0KKXXXXXXXXXXKKXXKXWWWWWWNXKkoc;:xXM");
            System.out.println("Ol;:cokOO0KKKKKKXXXXXXXXXXXXXXXXXKKK0KNWWWWWNk:...;:xNM");
            System.out.println("Ko;'...';:cloddxxkOO0KKKKKKKKKK00OOkxx0NWNNNNx. .';c0WM");
            System.out.println("Wk:,.........',;;;;:cccccllllllcc::::;oKNNNNNd. .':dXMM");
            System.out.println("M0c'.........'';:;,;:;::::::::::::,;:;l0NNNNKl...':kWMM");
            System.out.println("MNo,.........',:lccllccllolllloool::c:cx0000x;...'cKMMM");
            System.out.println("MWk;'..'.....',:llodddddddddddddddoll:cdxxxxc...',dNMMM");
            System.out.println("MMKc'.';;,...'':lclddddddddxxxxxddoll:cdxdxo,...,cOMMMM");
            System.out.println("MMWd,'';c:'..'';cccdxxxxxxxxxxxxxxdoc:cddddc...';oXMMMM");
            System.out.println("MMMO:,,;c:,.'',;cooxxxxxxxxxxxxxxxdoc:ldddl,...,;xWMMMM");
            System.out.println("MMMXl;;;cc:;',,,:lodxxxxxxxxxxxxxxol::ooooc'..,,:0MMMMM");
            System.out.println("MMMWk;;:cllc;,,';lodxdxkxddxxxxxxxol:clool;''';,oNMMMMM");
            System.out.println("MMMMKc;cclll:;,,:lodxdxkkxxxkkxdxdoc::clc;,,',;;OMMMMMM");
            System.out.println("MMMMWd:lllllc;',:cooddoodxxxkkxdxdoc::::,,,,',,lXMMMMMM");
            System.out.println("MMMMM0ccollllc;;;cclooc:clooloddxdl:;,,;,,;;,,;xWMMMMMM");
            System.out.println("MMMMMNo:ooolll:::c:::cllllodlccdkxo;;,;;,;:;;,cKMMMMMMM");
            System.out.println("MMMMMWkclooollc::cllollloddddoldkxc;;,;,;;;;;;dWMMMMMMM");
            System.out.println("MMMMMMXocooooolc:cllc:clodddoooolc;;;;;;;;;;;c0MMMMMMMM");
            System.out.println("MMMMMMWklloooolc::clllooddoc:cll:;;;;;;;;;;;;dNMMMMMMMM");
            System.out.println("MMMMMMWkllooodoc:;cc:coddolc;;;:c:;;;;;;,,;:;dXMMMMMMMM");
            System.out.println("MMMMMMNkoloddddlcclcccloolc:::::::;;;;,,,,;:cdXMMMMMMMM");
            System.out.println("MMMMMMWOooollodolcllllcc:;cl:;:;;,;;;;,,,,:llkWMMMMMMMM");
            System.out.println("MMMMMMMXo:ooc:coocc::;;,;okkxl:;;;;;;,,,;cocc0MMMMMMMMM");
            System.out.println("MMMMMMMWk;;ldl;;cl:;;;:codclxOdc::;;,,;cooc,oNMMMMMMMMM");
            System.out.println("MMMMMMMMXl',cxxl;:c:;:odolxkxk0x:;,,,:oxdl;:0MMMMMMMMMM");
            System.out.println("MMMMMMMMWk,.':okxc;;:clcoxk0Okkko;,;lxxoc:;dNMMMMMMMMMM");
            System.out.println("MMMMMMMMMXl..,:lkOd::cclodk0O0KOxooxkdodo:c0MMMMMMMMMMM");
            System.out.println("MMMMMMMMMWk,.';cldxo:;:cldk00KN0xxkxodOOlcxNMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMXl..,:llcc:,:clodkOXWKxxxdkKKxcoKMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMWk,.';clcc:;,;cdk0KKN0xdxOKX0dlkNMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMKl..';clc:;:lddld0KK0xxOKXXOodKWMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMNx,..',::;cddlcoxkO0XK0KXXKkdkNMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMM0c'.'''';lc;:odxkkk0NXXXK0xxKWMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMNx;'.'',::;:codxkkxxOKK00kxONMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMM0l;,,,;;,;cloddkOxddxO0kxxKWMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMNd;::;;,,;cloodk0OoloxkxdkNMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMM0c:;,,'';:clookKKxlloxxxKWMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMNk:,,'',;::lookKXOolldk0NMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMNd;'.',;;:clokKK0dllokNMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMKc...',;;:clk0K0dlclOWMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMKl'..',,;;:cx0K0dcclOWMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMNk:..'',,,;:oOOdccoxXMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMNd,'''''',;coolldONMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMWO:;:::;:ldddoodkKWMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMWOc;:::coddddookNMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMW0l,'..'';c:ckNMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMXdc;..;c:l0WMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMNKk:',:dXMMMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMWKdoOWMMMMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMWWMMMMMMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");

            if (stats.get(2)+25 > 100){
               stats.set(2,100);

            }else{
                stats.set(2, stats.get(2)+25);
            }

        }else{

            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWX00OOOO0XMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKddOOOOkokNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNOkKWMMMW0x0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXkkXMMMMW0xONWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKOkkONMMMMWX0kxkXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMKxxKNWMMMMMMMMWKkkXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0xONMMMMMMMMMMMXkxKMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNOdkKXNNNNNNXK0xdONMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMM|   +30 CD      |MMMMMMMMMMWX0xdxddodxdod0XWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0oloolllodlcOWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNxloxkxxxkkdldNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXxoxkOOOOOOxll0MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWOoodxddddxkxl:dWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNOddoodddoddxOd::dXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKoclldxdddxxxdxd:::lKWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMNkc;ccokkkxxkkkdodc,:;:kNMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMWNd'.';cok0KkookKKkdl:,'..oNWMMMMMMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMWk:,'',;coxkOxlclxOkdlc:;'.';xWMMMMMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMWKx:'',;:lodo:;;coxdlcc;,..;xKWMMMMMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMWk;'',:coxx:,;lxkxoc:,'',xWMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMWO'    .'::;;cooc'.  .;0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMWo.   ..;llccldoc,.   .xWMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMWN0xc.  ..',;:llcc::;;,,.  .ck0NWMMMMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMWXOxl,.  ...,;;;:cc::::::ccc:,.   .':oOXWMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMWXko:'.    ..'',,,;;:cc:::c:;;ccc::,..     'cxKWMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMW0o,.....   ...',,;;:::c::::cc;;:::;;,;,..      .ckNMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMNkc''.  ....   .''',;:;;;::;;:c:,,'',:;'.....      .,lkXMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMNx;.......',.','....';:c:,';:,..'..,'.;clc;'.,,...   ..'';xXMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMWKo'.'..;;.'''''',:;';loddddl;:cc:;:;',,,:c;';;:;';;.   ..''.:0WMMMMMMMMMM");
            System.out.println("MMMMMMMWKo:;;cc,;ol:;,:,..,:lo:;locco:'';cldl;'',,,'..;ll:;cll;,,','',;:o0WMMMMMMMM");
            System.out.println("MMMMMMW0l,,',,cdxxol:;::;:;,co:,:lc::cccodolcc:,;:c;.,ld:',:llcoocl;...;,;xNMMMMMMM");
            System.out.println("MMMMMWk:,,,..:dxxxoc,:::,';::;:lolldxxdoolollcllllo:;dkc'''':looolc,..  .,,dNMMMMMM");
            System.out.println("MMMMWk;..,,,:cc;cddool:,'';:c::lxxxOxdlc:;,;cloddllodko;,'''';lddl,......',,dNMMMMM");
            System.out.println("MMMWk:lc....,;;;lddoccc:;;:lddodOK0Oxxdlcc:coxkOkxxkkoc;,''..;clddc,.',.  ...dNMMMM");
            System.out.println("MMMXc';c,....';:lodxl;,;,,'',:ldkOOOkoc:,..,::codxO0Od:'.......:xdcc:,,,. ...lXMMMM");
            System.out.println("MMWx.  .:;co::::odxO0x:,....:ldoldkkkd;'...,;::ldxxkdodl;'....:dxkxolcc:,..'',dNMMM");
            System.out.println("MMK;   .;cod::ol:ldxO0dc,.,collodlc:lol,'';coxdooolod;,cc:;,'cdl:lc,cc,;;,'.. .xMMM");
            System.out.println("MWO'   .;l;..:l,..:lccoloxlccc:coc:,,cxdllxOxlccoodol,',;:llcl:,;'...;'.';'... lNMM");
            System.out.println("MKc....'co,.'c;...',',cd0Ooodxc;:cc;:cldkO0Od:,;lollc,',,:oocc:;,.. .''.,c,,:, 'OMM");
            System.out.println("Mk,'.',:lxd;lxc..',;::cox00xdo,,c:clolodxxxxkxc,'';cl;.;lol,.,ll:'.''cc;lc,,,;'.oWM");
            System.out.println("Wk;'.'''cddlcol;,;;::,,;,;d00xclox0Oocccc:cccdko:,,lxc;oxc.....;looxxoloc''. .;'lNM");
            System.out.println("Wk,..;,.,cccc:lllo:,.......:xOkkk00d;.',;,,,';ldxdcokooo,. .... .:k0xl::,,.  .''lNM");
            System.out.println("Wx'.',,,cl;';:loxdl:;...''':ldxkkxdodolcc:,..,cd0KkxOko,...... .,ldkdc,.,;.  ...lNM");
            System.out.println("M0c::'.':dc',:cl::clc'.';;cokxxkOO00xolllc;',;cxkkOOkd:'.'......,,cxdc'.,'.   ..dWM");
            System.out.println("MWk;''.':xdccllloc'......':dkdodox0Ol,,,....',;lddlcdl;'.........;odllc:;'.   .cXMM");
            System.out.println("MMk'.',,:lkd::;':dd:'....,cl;,:lccooc;,'....cxkkdl:lkc,:;''....,ll::co:,:;.....lNMM");
            System.out.println("MMKc.';''':::l;',,col;'';;;...,::,,,;cc:::clkKkl::;cd:..,;;,.'ldc,:ccc,..'.''..xWMM");
            System.out.println("MMWk'....;;'.;,..,:llo:,;'..'..,,'''.':odxxxoc;,'',;:;....,,,:o:;c:..'. ...'..cXMMM");
            System.out.println("MMMK:...,:c;.',. .;c;,:::'.........'',:lddlc:;'..........':lc;;;;;. .. ......;0MMMM");
            System.out.println("MMMWO;..';;;;::,,::;,'':cc:,...,,.',col:,'',:c,....,;..,cldo;,:lxo'.'.,;'...'OMMMMM");
            System.out.println("MMMMWO:,,..',;;;ccc;'..;:,;::'':l;;;cc,.'''',:c;'.,c:;oxocc:'';ox:',;::;...,xWMMMMM");
            System.out.println("MMMMMMKl;...;:;;clc:,.  .. .,c::olc;.....''''',;;,ldloo,','....;;,;,;;'...cKWMMMMMM");
            System.out.println("MMMMMMM0c,....';;;cc:,'...,,,;clol:,'''''.',:;;:::lo:,.,:,..';:cc;'.... .:KMMMMMMMM");
            System.out.println("MMMMMMMMXx;.. .coccc,.....;lc,,;:;,,;oxo:,:ldlcclol::oo:,'...',;,,'....'dXMMMMMMMMM");
            System.out.println("MMMMMMMMMWKkl,...',::;,....;:,,'..,;,,;;,,,;:;cl::::lko,....'',,...  'dKWMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMW0l:'.......',,',co:;:'.';:;',,;:lc::;;,;lo,....'........;OWMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMNOd:'...  ..''..'',:;,...,:clc;'..',..',. ....   ..',ckXWMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMWKx:..         ....... ..,;'.  ....    ..      .:d0NMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMWXOd:.       ...        ...        .      .;lkXWMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMWNKxl;'..                         ..;lx0NWMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMWWWNX0kxoc:,'..............',;codk0XNWWMMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMWWNNXXKK00OkkxxxxxxxxkkO00KKXXNWWMMMMMMMMMMMMMMMMMMMMMMMMMM");

            if (stats.get(3)+30 > 100){
                stats.set(3,100);
 
             }else{
                 stats.set(3, stats.get(3)+25);
             }
        }

    }











    /*Print Minatour */
    public static void miantour(int bossHealth, int bossDamage, int Misschance){

        System.out.println("\ndddddooodoooooooooooooooooooooooooooooollloooooooooooooooooooooooolcoooooooooooooooooodddddddddddddddddddd");
        System.out.println("ddddddooddooooooooooooooooooooooooooooooc::loooooooooooooooooooolc:coooooooooooooooooddddddddddddddddddddd");
        System.out.println("ddddddddddddoooooooooooooooooooooooooooool:;:looooooooooooooool:;:looooooooooooooooddddddddddddddddddddddd");
        System.out.println("ddddddddddddddooooooooooooooooooooooooooool;,;cooooooooooooool;,;coooodooooooooddddddddddddddddddddddddddd");
        System.out.println("dddddddddddddddooooooooooooooooooooooooool:;,,:oooooooooooodo:,,,:looddooooooooddddddddddddddddddddddddddd");
        System.out.println("ddddddddddddddddddoooooooooooooooooooool:;,,,;cooooooooooooooc;,,,;:lodooooooodddddddddddddddddddddddddddd");
        System.out.println("ddddddddddddddddddddoooooooooooooooool:;,,,;:loooooooooooooodoc:;,,,;:looooodddddddddddddddddddddddddddddd");
        System.out.println("dddddddddddddddddddddoooooooooooooolc;,,,,;:looooooooooooooooool:;,,,,;coooddddddddddddddddddddddddddddddd");
        System.out.println("dddddddddddddddddddddddodoooodooddol:;,,;;:looooooooooooooodoodol:;,,,;:lddddddddddddddddddddddddddddddddd");
        System.out.println("ddddddddddddddddddddddddoodoooodxxoc:::::clodoooooooooooooodddooolc:::::loxkxddodddddddddddddddddddddddddd");
        System.out.println("ddddddddddddddddddddddddoddooodOkolccclollodoooodooooooooooddooodolcllcccldO0xdddddddddddddddddddddddddddd");
        System.out.println("ddddddddddddddddddddddddddodddk0Odccccoollooodoooooodddddooooooodollolcccld0KOdddddddddddddddddddddddddddd");
        System.out.println("ddddddddddddddddddddddddddodddkOkdc::::::,;lo:,..''',,,,'''..,:ol,,;:::::cxO0Odddddddddddddddddddddddddddd");
        System.out.println("ddddddddddddddddddddddddddoododkxo:,'..... .........    ......... .....',:dkkxdddddddddddddddddddddddddddd");
        System.out.println("ddddddddddddddddddddddddoddoddodol;....   ........................   ...';lddddddddddddddddddddddddddddddd");
        System.out.println("ddddddddddddddddddddddddddddoodddoc'    ............................    'coddddddddddddddddddddddddddddddd");
        System.out.println("dddddddddddddddddddddddddooddol:;,..   ........ .............. ......   .',;clddddddddddddddddddddddddddddd");
        System.out.println("dddddddddddddddddddddddddol:,'..      .... ..                  .. ....      ..',:lddddddddddddddddddddddddd");
        System.out.println("ddddddddddddddddddddddooc,........   ......,c...           . ..c;......   ........,codddddddddddddddddddddd");
        System.out.println("ddddddddddddddddddddol;'..........  ........''.. ....'''......''........  ..........';ldddddddddddddddddddd");
        System.out.println("dddddddddddddddddddo;'.......  ...  ............'',;::::;;,'............  ....  ......';odddddddddddddddddd");
        System.out.println("dddddddddddddddddoc'..........        ........,,..',,,;,,'..,,........    .. ...........'cddddddddddddddddd");
        System.out.println("ddddddddddddddddl,..'''''........        ....,:'...,'',','..':,....       .........'''''..,lddddddddddddddd");
        System.out.println("ddddddddddddddo;..',,,,,..........         .'::;,',''''',,,,;::'.         .........',,,,,'..;oddddddddddddd");
        System.out.println("dddddddddddddl,..',,;;,............         .;,''..........',;;.         ...........',;;;,'..,ldddddddddddd");
        System.out.println("ddddddddddddl'...',;,,'................      ..''..........''..      ................',;;;'''.,lddddddddddd");
        System.out.println("dddddddddddc'.''',,,'...  .................    ..............    .................  ..'',,,,''.'ldddddddddd");
        System.out.println("ddddddddddc'.',,,'''...    ......''''''.......                .......'''''''.....    ...'',,,,,.'lddddddddd");
        System.out.println("dddddddddl,'',,,'.....       .....''''..........            ..........'''''....       ....'',,,,',ldddddddd");
        System.out.println("ddddddddo;''''''''.....       ....................          ..................      ......'''''',':odddddddd");
        System.out.println("ddddddddl,''''.........       ...................          ..................       ..........'''',ldddddddd");
        System.out.println("ddddddddc,,''........           .................          .................          .........'',,cdddddddd");
        System.out.println("dddddddo;'''.......       .;::;. ...............            ..............  .;cc;.        ......',':oddddddd");
        System.out.println("dddddddl,','..          .;oddddl,. ...........               ............ .,lddddo;.          ..',',lddddddd");
        System.out.println("dddddddl,''..          .ldddddddoc'.  .                            . .. .'cddddddddl.          ..,,,lxdddddd");
        System.out.println("dddddddc,'...         'lddddddddddoc'.                                .'coddddddddddo'         ..'',lxdddddd");
        System.out.println("ddddddl;'.....       ,odddddddddddddo,..        ...       ..        ..;odddddddddddddo,       .....';odddddd");
        System.out.println("ddddddc.... .       .odddddddddddddddo:...    .....       ....    ...:odddddddddddddddo'          ...cdddddx");
        System.out.println("ddddddl....        .:dddddddddddddddddl...    ....        ....   ....ldddddddddddddddddc.        ...'lxdddxx");
        System.out.println("dddddd:...        .cdddddddddddddddddo,.                    ..      .,odddddddddddddddddc.        ...cxddxxx");
        System.out.println("dddddo;...        .ldddddddddddddddddc. .     ..     ..     ..     . .cdddddddddddddddddl.        ...;odddxx");
        System.out.println("dddddd:....      .:cddddddddddddddddd;. ........            .......  .;oddddddddddddddddl:.      ...'cdddxx");
        System.out.println("ddddddc........ .,loddddddddddddddddc.......'....         .....''......cdddddddddddddddddo,  .....'''cddxdx");
        System.out.println("dddddd;.'..........',:lddddddddddddl'.......'..................''......'oddddddddddddl:;'.........''.;ddxxxx");
        System.out.println("dddddo,................cddddddddddo;....................................;oddddddddddc................;oxdxxx");
        System.out.println("dddddo,...      ......'ldddddddddo;. ............ ........  ........... .;ddddddddddl'......      ...,oxdxxx");
        System.out.println("dddddo,..       'lolllodddddddddo;. ...........    ......    ........... .;odddddddddollool'      ...,oxdddx");
        System.out.println("dddddo;..      .;dddddddddddoddo;. ..... ....       ....       .......... .;odddddddddddddd;       ..;dxdddd");
        System.out.println("ddddddl'.    ...;dddddddddddodd:......         ...        ...        .......:dddddddddddddd;...   ..'lxddddd");
        System.out.println("ddddddo;..   .  'oddddddddddddc......       .';lo:.      .:ol:'.       ......cddddddddddddo'  .   ..;ddddddd");
        System.out.println("dddddddl,..  .. .cdddddddddddc'.....      .;lddddoc'.  .'cddoddl;.      .....'ldddddddddddc. ..  ..,lddddddd");
        System.out.println("ddddddddc'.  .. .cdddoddodddo,.....       .,,:odoodolc:lododdo:,'.       .....,oddddddddddc. .   .'cdddddddd");
        System.out.println("ddddddddoc'   ...ldddddoooodc....            .ldooodooodoooddc.            ....cddddddddddl...  ..cddddddddd");
        System.out.println("ddddddddddl'.   'ldodooodooo;...             .ldoooooooooooodl.             ...;odddddddddl' . .'cdddddddddd");
        System.out.println("dddddddddool,. .,odooooooodoc..   .         .:oooooooooooooooo:.          . ...cododddddddo;. .;ldddddddddddd");
        System.out.println("ooooooooooooolclooooooooooooolc:ccc;.       ,oooooooooooooooooo,       .;cccccloooooooooddoolcloddddddddddddd");
        System.out.println("oooooooooooooooooooooooooooooooooooc.      'looooooooooooooooool.      .coooooooooooooooooooooooooooodddddddd");
        System.out.println("oooooooooooooooooooooooooooooooooo:...    .:oooooooooooooooooooo:.    ...:ooooooooooooooooooooooooooooooooooo");
        System.out.println(String.format("ooooooooooooooooooooooooooooooool;.... . .;oooooooooooooooooooooo;. . ....;loooooooooo| Health: %d   |ooddddd", bossHealth));
        System.out.println("oooooooooooooooooooooooooooooooc'.... .. 'looooooooooooooooooooool' .  ....'coooooooooooooooodddddddddddddddd");
        System.out.println(String.format("oooooooooooooooooooooooooooooo;..........:oooooooooooooooooooooooo:. ........;ooodoood| Damage: %d   |dddddd", bossDamage));
        System.out.println("ooooooooooooooooooooooooooool,..........'ldoooooooooooooooooooooodl'..........'looooooodooddddddddddddddddddd");
        System.out.println(String.format("ooooooooooooooooooooooooooo:...'........,oooooooooooooooooooooooooo;. ......''..:ooood| Mchance: %d  |oodddd", Misschance));
        System.out.println("oooooooooooooooooooooooooc,.........   .:ooooooooooooooooooooooooooc.    ........,loooooooooooooooooooooooooo");
        System.out.println("ooooooooooooooooooooolol;.......    .  .:olloollllllllllolllooooooo:.  .     ......:loooooooooooooooooooooooo");
        System.out.println("olllllllllllllllllllllc'. ....      .  .;lccccccccccccccccccccccccl;.  .      ......'looooooooooooooooooooooo");
        System.out.println("ollllllllllllllllllcc;.  ....          .';;;;;;;;;;;;;;;;;;;;;;,,;;'.          ..... .:lllllllloooooooooooooo");
        System.out.println("ooooooooooolllllllllc,......      .....';;;:::::::::::::::::::::;;;;'.....      ......,lolooooooooooooooooooo");
        System.out.println("oooooooooooooooooooooolllcccc:::ccccllollloooooooloooooooooooooooooooollccccccccccclloooooooooooooooooooooood");
        System.out.println("ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooddddodddddddd");
        System.out.println("ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooodddooddddddddddddddddd");



    }


    /*Prints Spike */
    public static void spike(){

        System.out.println("\n                                                              ;                                                            ");
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

        System.out.println("\n    ___                    ___    __________________       __      __     ___               ");
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

        System.out.println("\n     ______");
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
                    drops();
                    System.out.println(
                     "\nThere are three Paths you can take, but your guts tell you two of which, will lead to your death!");

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

                Boss(100, 6, 80);
                int bossHealth = stats.get(4);
                int bossDamage = stats.get(5);
                int misschance = stats.get(6);
                int maxTarget = 100;

                System.out.println("***Their is a minatour approching and he is fast!***");
                miantour(bossHealth, bossDamage, misschance);
                
                System.out.println("***Their is no way out but to fight!***");

                if (battle(bossHealth, bossHealth, maxTarget)){

                    win();
                    System.out.println("\n**You have defeated the minatour!");
                    drops();

                    

                }else{
                    death(name);
                }

            }else{

                System.out.println("Invalid input so you die");
                death(name);
            }
            
            
        }

        return true;
    }
}