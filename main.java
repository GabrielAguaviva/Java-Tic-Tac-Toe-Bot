package TicTacToeBot;
import java.util.Scanner;
import java.util.Random;

public class main {

    public static void main(String[] args) {
    	int[] tiles = new int[9];
    	int[][] tilesHistory = new int[10][9];
    	int gamesCounter = 0;
    	int gameEnd = 0;
    	int gameStop = 0;    	
    	int historyPrompt = 0;
    	Scanner input = new Scanner(System.in);
    	

    	do {
    		
    		for (int i = 0; i < tiles.length; i++) { // showcases initial  board
    			if ((i + 1)% 3 != 0) {
    				System.out.print((i+1) + " ");
    			} else
    				System.out.println(i+1);
    		}	
    		
	    	while (gameEnd == 0) {    			
	            System.out.println("Your turn");
	    	    int tilesInput = input.nextInt() -1;
	    	    input.nextLine(); 
	    	    tiles[tilesInput] = 1;	   
	    	    	    	        	    
	    	    gameEnd = endFirstRow(tiles); // checks for game end from player side
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
	    	    
	            if (gameEnd == 0) {
	    	    System.out.println("Opponents turn");
	    	    tilesInput = randomOpponent(tiles);
	    	    tiles[tilesInput] = -1;
	            }
	            
	    	    if (gameEnd == 0) { // checks for game end from opponents side
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
	    	    	    	    
	    	    for (int i = 0; i < tiles.length; i++) { // showcases current board
	    			if ((i + 1)% 3 != 0) {
	    				if (tiles[i] != 0) {
	    					if (tiles[i] > 0) {
	    					System.out.print("O ");
	    					} else {
	    						System.out.print("X ");
	    					}
	    				} else {
	    				System.out.print((i+1) + " ");
	    				}
	    			} else {
	    				if (tiles[i] != 0) {
	    					if (tiles[i] > 0) {
	        					System.out.println("O ");
	        					} else {
	        						System.out.println("X ");
	        					}
	    				} else {
	    				System.out.println(i+1);
	    				}
	    			}
	    		}
	    	    
	    	    // end game prompts
	    	    if (gameEnd > 0) {
	    	        System.out.println("Congrats, you win!");
	    	    }
	    	    else if (gameEnd < 0)  {
	    	        System.out.println("Sorry, you lost!");
	    	    }
	    			
	    	}
	    	
	    	// out of loop
	    	if (gameEnd != 0) { 
    			
	    		for (int i = 0; i < tiles.length; i++) { // saves board history, cap is 5
    				tilesHistory[gamesCounter][i] = tiles[i];
    				tiles[i] = 0;
    			}
    			
	    		if (gamesCounter < 10)
	    			gamesCounter += 1;
	    		else 
    				gamesCounter = 0;

		    	System.out.println("Would you like to continue? Y/N");
	    	    String gameContinue = input.nextLine();
	    		if (gameContinue.equals("Y") || gameContinue.equals("y")) {
	    			gameEnd = 0;
	    		} else 
	    			gameStop = 1;
	    	}
	    	
    	} while (gameStop == 0);
    	
    	System.out.println("Which game would you like to look at?");
    	System.out.println("Games available: " + gamesCounter + "/10");
	    
	    historyPrompt = input.nextInt() - 1;
	    
		    for (int i = 0; i < tiles.length; i++) { // showcases history's board
				if ((i + 1)% 3 != 0) {
					if (tilesHistory[historyPrompt][i] != 0) {
						if (tilesHistory[historyPrompt][i] > 0) {
						System.out.print("O ");
						} else {
							System.out.print("X ");
						}
					} else {
					System.out.print((i+1) + " ");
					}
				} else {
					if (tilesHistory[historyPrompt][i]!= 0) {
						if (tilesHistory[historyPrompt][i] > 0) {
	    					System.out.println("O ");
	    					} else {
	    						System.out.println("X ");
	    					}
					} else {
					System.out.println(i+1);
					}
				}
			}    	
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
    
    // different CPU modes
    
    public static int randomOpponent(int[] tilesRow) {
    	Random rand = new Random();
    	int randomNumber = rand.nextInt(9);
    	while (tilesRow[randomNumber] != 0) {
    		randomNumber = rand.nextInt(9);
    	}
    	return randomNumber;
    }
}

