public class Slots {
    private int[][] grid;
    private int score;

    public Slots() {
        grid = new int[3][5];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                grid[i][j] = (int) (Math.random() * 10);
            }
        }

        //adds a pattern
        int pat = (int) (Math.random() * 8);
        int sendEmotionalAndMentalHelp = 0;
        if (pat < 3) {
            int  godHelpMe = (int) (Math.random() * 10);
            for (int i = 0; i < 5;i++) {
                grid[pat][i]=godHelpMe;
            }
            sendEmotionalAndMentalHelp = godHelpMe;
        } else {
            pat -= 3;
            int  godHelpMe = (int) (Math.random() * 10);
            for (int i = 0; i < 3; i++) {
                grid[i][pat] = godHelpMe;
            }
            sendEmotionalAndMentalHelp = godHelpMe;
        }

        int addMoreChance = (int) (Math.random() * 10);
        if (addMoreChance >= 5) {
            pat = (int) (Math.random() * 8);
            int fuck;
            addMoreChance = (int) (Math.random() * 10);
            if (addMoreChance < 5) {
                fuck = sendEmotionalAndMentalHelp;
            }else {
                fuck = (int) (Math.random() * 10);
            }
            if (pat < 3) {
                for (int i = 0; i < 5;i++) {
                    grid[pat][i]= fuck;
                }

            } else {
                pat -= 3;
                for (int i = 0; i < 3; i++) {
                    grid[i][pat] = fuck;
                }
            }
        }

        score = 0;
        //add the base value of a spin
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                score += grid[i][j];
            }
        }

        //Pattern check
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][2] == grid[i][3] && grid[i][3] == grid[i][4]) {
                score+= grid[i][1] * 5;
            }
        }

        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]) {
                score+= grid[0][i] * 3;
            }
        }





    }


    public int[][] getGrid() {
        return grid;
    }

    public int getScore() {
        return score;
    }

    public void reroll(){
        grid = new int[3][5];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                grid[i][j] = (int) (Math.random() * 10);
            }
        }

        //adds a pattern
        int pat = (int) (Math.random() * 8);
        int sendEmotionalAndMentalHelp = 0;
        if (pat < 3) {
            int  godHelpMe = (int) (Math.random() * 10);
            for (int i = 0; i < 5;i++) {
                grid[pat][i]=godHelpMe;
            }
            sendEmotionalAndMentalHelp = godHelpMe;
        } else {
            pat -= 3;
            int  godHelpMe = (int) (Math.random() * 10);
            for (int i = 0; i < 3; i++) {
                grid[i][pat] = godHelpMe;
            }
            sendEmotionalAndMentalHelp = godHelpMe;
        }

        int addMoreChance = (int) (Math.random() * 10);
        if (addMoreChance >= 5) {
            pat = (int) (Math.random() * 8);
            int fuck;
            addMoreChance = (int) (Math.random() * 10);
            if (addMoreChance < 5) {
                fuck = sendEmotionalAndMentalHelp;
            }else {
                fuck = (int) (Math.random() * 10);
            }
            if (pat < 3) {
                for (int i = 0; i < 5;i++) {
                    grid[pat][i]= fuck;
                }

            } else {
                pat -= 3;
                for (int i = 0; i < 3; i++) {
                    grid[i][pat] = fuck;
                }
            }
        }

        score = 0;
        //add the base value of a spin
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                score += grid[i][j];
            }
        }

        //Pattern check
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][2] == grid[i][3] && grid[i][3] == grid[i][4]) {
                score+= grid[i][1] * 5;
            }
        }

        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]) {
                score+= grid[0][i] * 3;
            }
        }
        System.out.println("Rolling Slot Machine!");
    }

    public double checkBet() {
        if (score >= 200) {
            return 4;
        } else if (score >= 130) {
            return 2;
        } else if (score >= 100) {
            return ((double) score /100) ;
        } else if (score >= 50){
            return  ((double) score /100);
        } else {
            return 0;
        }

    }
}
