/**
 * class PetBattlefield.
 * @author Alvin Le
 * @version 1.0
 */
public class PetBattlefield {
    private Pet[] firstTeam;
    private Pet[] secondTeam;
    /**
     * @param args string array
     * main driver.
     */
    public static void main(String[] args) {
        Hippo h1 = new Hippo();
        Skunk s1 = new Skunk();
        Turtle t1 = new Turtle();
        Hippo h2 = new Hippo(6, 5, 2);
        Skunk s2 = new Skunk(4, 4, 2);
        Turtle t2 = new Turtle(4, 3, true);

        Pet[] firstTeam = {h1, null, s2, t2, null};
        Pet[] secondTeam = {null, h2, t1, null, s1};

        PetBattlefield battle1 = new PetBattlefield(firstTeam, secondTeam);

        battle1.compareTeams();
        battle1.battle();
    }
    /**
     * @param firstTeam array of Pet objects
     * @param secondTeam array of Pet objects
     */
    public PetBattlefield(Pet[] firstTeam, Pet[] secondTeam) {
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;

        if (firstTeam.length > 5 || secondTeam.length > 5) {
            for (int i = 0; i < 5; i = i + 1) {
                firstTeam[i] = null;
                secondTeam[i] = null;
            }
        }
    }
    /**
     * @return String
     */
    public String toString() {
        String output = "First Team: ";

        for (int i = 0; i < firstTeam.length; i = i + 1) {
            if (firstTeam[i] == null) {
                output = output + "Empty";
                if (i < firstTeam.length - 1) {
                    output = output + ", ";
                }
            } else {
                output = output + firstTeam[i].toString();
                if (i < firstTeam.length - 1) {
                    output = output + ", ";
                }
            }
        }

        output = output + " vs Second Team: ";

        for (int i = 0; i < secondTeam.length; i = i + 1) {
            if (secondTeam[i] == null) {
                output = output + "Empty";
                if (i < secondTeam.length - 1) {
                    output = output + ", ";
                }
            } else {
                output = output + secondTeam[i].toString();
                if (i < secondTeam.length - 1) {
                    output = output + ", ";
                }
            }
        }
        return output;
    }
    /**
     * determines which team is likely to win.
     */
    public void compareTeams() {
        int winningChances = 0;

        for (int i = 0; i < firstTeam.length; i = i + 1) {
            if (firstTeam[i] == null) {
                if (secondTeam[i] == null) {
                    winningChances = winningChances;
                } else {
                    winningChances = winningChances - 1;
                }
            } else {
                winningChances = winningChances + firstTeam[i].compareTo(secondTeam[i]);
            }
        }

        if (winningChances > 0) {
            System.out.println("The first team will probably win.");
        } else if (winningChances == 0) {
            System.out.println("It is an even match.");
        } else {
            System.out.println("The second team will probably win.");
        }
    }
    /**
     * conducts the match or battle.
     */
    public void battle() {
        int intFT = 0;
        int intST = 0;
        int enderFT = 0;
        int enderST = 0;
        boolean match = true;

        while (match == true) {
            if (firstTeam[intFT] == null) {
                enderFT = enderFT + 1;
                if (intFT < firstTeam.length - 1) {
                    intFT = intFT + 1;
                }
            }

            if (secondTeam[intST] == null) {
                enderST = enderST + 1;
                if (intST < secondTeam.length - 1) {
                    intST = intST + 1;
                }
            }

            while (firstTeam[intFT] != null && secondTeam[intST] != null) {
                if (secondTeam[intST] instanceof Skunk) {
                    ((Skunk) secondTeam[intST]).sprayPet(firstTeam[intFT]);
                }

                if (firstTeam[intFT] instanceof Skunk) {
                    ((Skunk) firstTeam[intFT]).sprayPet(secondTeam[intST]);
                }

                firstTeam[intFT].attackPet(secondTeam[intST]);

                if (secondTeam[intST].hasFainted() == false) {
                    secondTeam[intST].attackPet(firstTeam[intFT]);
                } else {
                    secondTeam[intST] = null;
                }

                if (firstTeam[intFT].hasFainted() == true) {
                    firstTeam[intFT] = null;
                }
            }

            if (enderFT > 4 && enderST > 4) {
                System.out.println("Both teams fainted.");
                match = false;
            } else if (enderFT > 4) {
                System.out.println("The second team won!");
                match = false;
            } else if (enderST > 4) {
                System.out.println("The first team won!");
                match = false;
            }
        }
    }
    /**
     * @param pets array of objects
     */
    public void setFirstTeam(Pet[] pets) {
        this.firstTeam = pets;
    }
    /**
     * @param pets array of objects
     */
    public void setSecondTeam(Pet[] pets) {
        this.secondTeam = pets;
    }
    /**
     * @return object
     */
    public Pet[] getFirstTeam() {
        return this.firstTeam;
    }
    /**
     * @return object
     */
    public Pet[] getSecondTeam() {
        return this.secondTeam;
    }
}
