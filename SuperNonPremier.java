import java.io.*;
import java.util.*;

/* Checker :
   permet de tester grâce à la méthode check si une valeur est un nombre super non-premier.

   conseil : puisqu'il faut déterminer si plein de valeurs sont ou non des nombres premiers, il est 
   judicieux de générer la liste des nombres premiers de 2 jusqu'à lim.
 */
class Checker {
    int lim; // la valeur max. des nombres à traiter
    
    // autres attributs
    
    public Checker(int lim) {
	this.lim = lim;
	// init. autres attributs
    }

    public String check(int value) {
	// retourne "yes" su value est un super non-premier
	// "false" sinon

        ArrayList<Integer> titi = DecomposerUnNombre(value);
        for(Integer toto : titi ){
            System.out.println(toto);
            if ( ! testPremier(toto)){
                if(toto != titi.get(titi.size()-1))
                    return "Faux";
            }
        }
        if (testPremier(titi.get(titi.size()-1))){
            return "Faux";
        }
        return "Vrai";
    }

    public boolean testPremier(int value){
        if (value==0) return true ;
        if (value==2) return true ;
        if (value==1) return true ;
        if (value%2==0) return false ;

        int valEnCour = 3 ;

        while (Math.sqrt(value) > valEnCour){
            if (value % valEnCour == 0 ) return false ;

            valEnCour += 2;
        }
        return true ;
    }

    public ArrayList<Integer> DecomposerUnNombre(int value){
        ArrayList<Integer> finalList = new ArrayList<Integer>();

        ArrayList<Integer> digitList = new ArrayList<Integer>();


        while (value > 0 ){
            digitList.add(value%10);
            finalList.add(value%10);

            value /= 10;
        }
        Collections.reverse(digitList);

        int lengthValue = finalList.size();

        for (int i = 1 ; i < lengthValue ; i++){

            int startingPoint = 0;

            while (lengthValue > startingPoint + i ) {
                int finalValue = 0 ;

                for (int j = 0; j <=  i ; j++) {
                    finalValue *=10;
                    finalValue += digitList.get(startingPoint + j );
                }

                finalList.add(finalValue);

                startingPoint++ ;
            }

        }

        return finalList ;
    }




}

    
class SuperNonPremier {

    public static void main(String[] args) {
	Locale.setDefault(Locale.ENGLISH);
	
	Checker c = new Checker(100000); // check for number till 100000
	Scanner scan = new Scanner(System.in);
	int nbCases = scan.nextInt(); // get numbers of cases from stdin
        
        for(int i=0;i<nbCases;i++) {
	    int value = scan.nextInt(); // get the value from stdin
            System.out.println(c.check(value)); // print answer on stdout
        }
    }
}
