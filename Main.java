import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	int[] tiles = new int[9];
    	int gameEnd = 0;
    	Scanner input = new Scanner(System.in);
    	

    	while (gameEnd == 0) {
            System.out.println("Enter which tile you want to fill in");
    	    int tilesInput = input.nextInt() -1;
    	    tiles[tilesInput] = 1;
    	    
    	    System.out.println(tilesInput);
    	    
    	    gameEnd = endFirstRow(tiles);
    	    
    	    if (gameEnd == 0) {
    	        gameEnd = endSecondRow(tiles);
    	        if (gameEnd == 0) {
    	            gameEnd = endThirdRow(tiles);
    	            if (gameEnd == 0) {
    	            gameEnd = endFirstColumn(tiles);
    	                if (gameEnd == 0) {
    	                gameEnd = endSecondColumn(tiles);
    	                    if (gameEnd == 0) {
    	                    gameEnd = endThirdColumn(tiles);
    	                        if (gameEnd == 0) {
    	                        gameEnd = endFirstDiag(tiles);
    	                            if (gameEnd == 0) {
    	                            gameEnd = endSecondDiag(tiles);
    	                            }
    	                        }
    	                    }
    	                }
    	            }
    	        }
    	    }
    	 }
    
    	    
    	    if (gameEnd > 0)
    	        System.out.println("Congrats, you win!");
    	    else if (gameEnd < 0)
    	        System.out.println("Sorry, you lost!");

    }
    
    // end game conditions
    
    public static int endFirstRow(int[] tilesRow) { 
    int check = tilesRow[0] + tilesRow[1] + tilesRow[2];
    int returnValue = 0;
    
        if (check % 3 == 0) {
            if (check > 0) {
            returnValue = 1;
            } else if (check < 0) {
                returnValue = -1;
            }
        }
    return returnValue;    
    }
    
    public static int endSecondRow(int[] tilesRow) { 
    int check = tilesRow[3] + tilesRow[4] + tilesRow[5];
    int returnValue = 0;
    
        if (check % 3 == 0) {
            if (check > 0) {
            returnValue = 1;
            } else if (check < 0) {
                returnValue = -1;
            }
        }
    return returnValue;    
    }
    
    public static int endThirdRow(int[] tilesRow) { 
    int check = tilesRow[6] + tilesRow[7] + tilesRow[8];
    int returnValue = 0;
    
        if (check % 3 == 0) {
            if (check > 0) {
            returnValue = 1;
            } else if (check < 0) {
                returnValue = -1;
            }
        }
    return returnValue;    
    }
    
    public static int endFirstColumn(int[] tilesRow) { 
    int check = tilesRow[0] + tilesRow[3] + tilesRow[6];
    int returnValue = 0;
    
        if (check % 3 == 0) {
            if (check > 0) {
            returnValue = 1;
            } else if (check < 0) {
                returnValue = -1;
            }
        }
    return returnValue;    
    }

    public static int endSecondColumn(int[] tilesRow) { 
    int check = tilesRow[1] + tilesRow[4] + tilesRow[7];
    int returnValue = 0;
    
        if (check % 3 == 0) {
            if (check > 0) {
            returnValue = 1;
            } else if (check < 0) {
                returnValue = -1;
            }
        }
    return returnValue;    
    }

    public static int endThirdColumn(int[] tilesRow) { 
    int check = tilesRow[2] + tilesRow[5] + tilesRow[8];
    int returnValue = 0;
    
        if (check % 3 == 0) {
            if (check > 0) {
            returnValue = 1;
            } else if (check < 0) {
                returnValue = -1;
            }
        }
    return returnValue;    
    }

    public static int endFirstDiag(int[] tilesRow) { 
    int check = tilesRow[0] + tilesRow[4] + tilesRow[8];
    int returnValue = 0;
    
        if (check % 3 == 0) {
            if (check > 0) {
            returnValue = 1;
            } else if (check < 0) {
                returnValue = -1;
            }
        }
    return returnValue;    
    }

    public static int endSecondDiag(int[] tilesRow) { 
    int check = tilesRow[2] + tilesRow[4] + tilesRow[6];
    int returnValue = 0;
    
        if (check % 3 == 0) {
            if (check > 0) {
            returnValue = 1;
            } else if (check < 0) {
                returnValue = -1;
            }
        }
    return returnValue;    
    }
}

