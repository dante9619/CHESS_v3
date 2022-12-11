import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int figure_now = 0;
        int[][] field = new int[8][8];

        FileReader fr = new FileReader("data_chess.TXT");
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        while (line != null) {
            try {
                String figure = line;
                line = reader.readLine();
                String line_column = line;
                line = reader.readLine();
                char ln = line_column.charAt(0);
                char cl = line_column.charAt(2);
                int l = ln - '0';
                int c = cl - '0';
                if (l < 9 && l > 0 && c < 9 && c > 0) {
                    switch (figure) {
                        case "king" -> figure_now = 1;
                        case "queen" -> figure_now = 2;
                        case "rook" -> figure_now = 3;
                        case "bishop" -> figure_now = 4;
                        case "knight" -> figure_now = 5;
                    }
                    field[l - 1][c - 1] = figure_now;
                    figure_now = 0;
                }
                else {
                    System.out.println(figure + " имеет некорректные координаты: " + line_column);
                }
            }
            catch (Exception e) {
                System.out.println("Часть введенных данных некорректна");
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (field[i][j] != 0) {
                    if (field[i][j] == 1) {
                        if (i + 1 < 8 && j + 1 < 8) {
                            if (field[i + 1][j + 1] != 0) {
                                System.out.println("Король на " + (i + 1) + "," + (j + 1) + " бьет " + field[i + 1][j + 1]);
                            }
                        }
                        if (j + 1 < 8) {
                            if (field[i][j + 1] != 0) {
                                System.out.println("Король на " + (i + 1) + "," + (j + 1) + " бьет " + field[i][j + 1]);
                            }
                        }
                        if (i - 1 > -1 && j + 1 < 8) {
                            if (field[i - 1][j + 1] != 0) {
                                System.out.println("Король на " + (i + 1) + "," + (j + 1) + " бьет " + field[i - 1][j + 1]);
                            }
                        }
                        if (i - 1 > -1) {
                            if (field[i - 1][j] != 0) {
                                System.out.println("Король на " + (i + 1) + "," + (j + 1) + " бьет " + field[i - 1][j]);
                            }
                        }
                        if (i - 1 > -1 && j - 1 > -1) {
                            if (field[i - 1][j - 1] != 0) {
                                System.out.println("Король на " + (i + 1) + "," + (j + 1) + " бьет " + field[i - 1][j - 1]);
                            }
                        }
                        if (j - 1 > -1) {
                            if (field[i][j - 1] != 0) {
                                System.out.println("Король на " + (i + 1) + "," + (j + 1) + " бьет " + field[i][j - 1]);
                            }
                        }
                        if (i + 1 < 8 && j - 1 > -1) {
                            if (field[i + 1][j - 1] != 0) {
                                System.out.println("Король на " + (i + 1) + "," + (j + 1) + " бьет " + field[i + 1][j - 1]);
                            }
                        }
                        if (i + 1 < 8) {
                            if (field[i + 1][j] != 0) {
                                System.out.println("Король на " + (i + 1) + "," + (j + 1) + " бьет " + field[i + 1][j]);
                            }
                        }
                    }
                    else if (field[i][j] == 2) {
                        int n = 1;
                        while (i - n > -1 && j - n > -1) {
                            if (field[i - n][j - n] != 0) {
                                System.out.println("Ферзь на " + (i + 1) + "," + (j + 1) + " бьет фигуру на " + (i-n+1) + "," + (j-n+1));
                            }
                            n += 1;
                        }
                        n = 1;
                        while (i - n > -1 && j + n < 8) {

                            if (field[i - n][j + n] != 0) {
                                System.out.println("Ферзь на " + (i + 1) + "," + (j + 1) + " бьет фигуру на " + (i-n+1) + "," + (j+n+1));
                            }
                            n += 1;
                        }
                        n = 1;
                        while (i + n < 8 && j - n > -1) {
                            if (field[i + n][j - n] != 0) {
                                System.out.println("Ферзь на " + (i + 1) + "," + (j + 1) + " бьет фигуру на " + (i+n+1) + "," + (j-n+1));
                            }
                            n += 1;
                        }
                        n = 1;
                        while (i + n < 8 && j + n < 8) {
                            if (field[i + n][j + n] != 0) {
                                System.out.println("Ферзь на " + (i + 1) + "," + (j + 1) + " бьет фигуру на " + (i+n+1) + "," + (j+n+1));
                            }
                            n += 1;
                        }
                        n = 1;
                        while (i - n > -1) {
                            if (field[i - n][j] != 0) {
                                System.out.println("Ферзь на " + (i + 1) + "," + (j + 1) + " бьет фигуру на " + (i-n+1) + "," + (j+1));
                            }
                            n += 1;
                        }
                        n = 1;
                        while (i + n < 8) {
                            if (field[i + n][j] != 0) {
                                System.out.println("Ферзь на " + (i + 1) + "," + (j + 1) + " бьет фигуру на " + (i+n+1) + "," + (j+1));
                            }
                            n += 1;
                        }
                        n = 1;
                        while (j - n > -1) {
                            if (field[i][j - n] != 0) {
                                System.out.println("Ферзь на " + (i + 1) + "," + (j + 1) + " бьет фигуру на " + (i+1) + "," + (j-n+1));
                            }
                            n += 1;
                        }
                        n = 1;
                        while (j + n < 8) {
                            if (field[i][j + n] != 0) {
                                System.out.println("Ферзь на " + (i + 1) + "," + (j + 1) + " бьет фигуру на " + (i+1) + "," + (j+n+1));
                            }
                            n += 1;
                        }
                    }
                    else if (field[i][j] == 3) {
                        int n = 1;
                        while (i - n > -1 && j - n > -1) {
                            if (field[i - n][j - n] != 0) {
                                System.out.println("Ладья на " + (i + 1) + "," + (j + 1) + " бьет фигуру на " + (i-n+1) + "," + (j-n));
                            }
                            n += 1;
                        }
                        n = 1;
                        while (i - n > -1 && j + n < 8) {
                            if (field[i - n][j + n] != 0) {
                                System.out.println("Ладья на " + (i + 1) + "," + (j + 1) + " бьет фигуру на " + (i-n+1) + "," + (j+n));
                            }
                            n += 1;
                        }
                        n = 1;
                        while (i + n < 8 && j - n > -1) {
                            if (field[i + n][j - n] != 0) {
                                System.out.println("Ладья на " + (i + 1) + "," + (j + 1) + " бьет фигуру на " + (i+n+1) + "," + (j-n+1));
                            }
                            n += 1;
                        }
                        n = 1;
                        while (i + n < 8 && j + n < 8) {
                            if (field[i + n][j + n] != 0) {
                                System.out.println("Ладья на " + (i + 1) + "," + (j + 1) + " бьет фигуру на " + (i+n+1) + "," + (j+n+1));
                            }
                            n += 1;
                        }
                    }
                    else if (field[i][j] == 4) {
                        int n = 1;
                        while (i - n > -1) {
                            if (field[i - n][j] != 0) {
                                System.out.println("Слон на " + (i + 1) + "," + (j + 1) + " бьет фигуру на " + (i-n+1) + "," + (j+1));
                            }
                            n += 1;
                        }
                        n = 1;

                        while (i + n < 8) {
                            if (field[i + n][j] != 0) {
                                System.out.println("Слон на " + (i + 1) + "," + (j + 1) + " бьет фигуру на " + (i+n+1) + "," + (j+1));
                            }
                            n += 1;
                        }
                        n = 1;
                        while (j - n > -1) {
                            if (field[i][j - n] != 0) {
                                System.out.println("Слон на " + (i + 1) + "," + (j + 1) + " бьет фигуру на " + (i+1) + "," + (j-n+1));
                            }
                            n += 1;
                        }
                        n = 1;
                        while (j + n < 8) {
                            if (field[i][j + n] != 0) {
                                System.out.println("Слон на " + (i + 1) + "," + (j + 1) + " бьет фигуру на " + (i+1) + "," + (j+n+1));
                            }
                            n += 1;
                        }
                    }
                    else if (field[i][j] == 5) {
                        if (i + 2 < 8) {
                            if (j + 1 < 8 && field[i + 2][j + 1] != 0) {
                                System.out.println("Конь на " + (i + 1) + "," + (j + 1) + " бьет фигуру на " + (i+3) + "," + (j+2));
                            }
                            if (j - 1 > -1 && field[i + 2][j - 1] != 0) {
                                System.out.println("Конь на " + (i + 1) + "," + (j + 1) + " бьет фигуру на " + (i+3) + "," + (j));
                            }
                        }
                        if (i - 2 > -1) {
                            if (j + 1 < 8 && field[i - 2][j + 1] != 0) {
                                System.out.println("Конь на " + (i + 1) + "," + (j + 1) + " бьет фигуру на " + (i-1) + "," + (j+2));
                            }
                            if (j - 1 > -1 && field[i - 2][j - 1] != 0) {
                                System.out.println("Конь на " + (i + 1) + "," + (j + 1) + " бьет фигуру на " + (i-1) + "," + j);
                            }
                        }
                        if (j + 2 < 8) {
                            if (i + 1 < 8 && field[i + 1][j + 2] != 0) {
                                System.out.println("Конь на " + (i + 1) + "," + (j + 1) + " бьет фигуру на " + (i+2) + "," + (j+3));
                            }
                            if (i - 1 > -1 && field[i - 1][j + 2] != 0) {
                                System.out.println("Конь на " + (i + 1) + "," + (j + 1) + " бьет фигуру на " + i + "," + (j+3));
                            }
                        }
                        if (j - 2 > -1) {
                            if (i + 1 < 8 && field[i + 1][j - 2] != 0) {
                                System.out.println("Конь на " + (i + 1) + "," + (j + 1) + " бьет фигуру на " + (i+2) + "," + (j-1));
                            }
                            if (i - 1 > -1 && field[i - 1][j - 2] != 0) {
                                System.out.println("Конь на " + (i + 1) + "," + (j + 1) + " бьет фигуру на " + (i) + "," + (j-1));
                            }
                        }
                    }
                }
            }
        }

        reader.close();

        System.out.println("┌————┬————┬————┬————┬————┬————┬————┬————┐");
        img1(0, field);
        System.out.println("├————┼————┼————┼————┼————┼————┼————┼————┤");
        img2(1, field);
        System.out.println("├————┼————┼————┼————┼————┼————┼————┼————┤");
        img1(2, field);
        System.out.println("├————┼————┼————┼————┼————┼————┼————┼————┤");
        img2(3, field);
        System.out.println("├————┼————┼————┼————┼————┼————┼————┼————┤");
        img1(4, field);
        System.out.println("├————┼————┼————┼————┼————┼————┼————┼————┤");
        img2(5, field);
        System.out.println("├————┼————┼————┼————┼————┼————┼————┼————┤");
        img1(6, field);
        System.out.println("├————┼————┼————┼————┼————┼————┼————┼————┤");
        img2(7, field);
        System.out.println("└————┴————┴————┴————┴————┴————┴————┴————┘");
    }
    private static void img1(int i, int[][] field) {
        for (int j = 0; j < 8; j++) {
            if (j % 2 == 0) {System.out.print("│ ");}
            else if (j % 2 != 0) {System.out.print("│▓");}
            if (field[i][j] != 0 && j % 2 == 0) {
                if (field[i][j] == 1) {
                    System.out.print("Ki ");
                } else if (field[i][j] == 2) {
                    System.out.print("Qu ");
                } else if (field[i][j] == 3) {
                    System.out.print("Ro ");
                } else if (field[i][j] == 4) {
                    System.out.print("Bi ");
                } else if (field[i][j] == 5) {
                    System.out.print("Kn ");
                }
            } else if (j % 2 == 0) {
                System.out.print("   ");
            } else if (field[i][j] != 0 && j % 2 != 0) {
                if (field[i][j] == 1) {
                    System.out.print("Ki▓");
                } else if (field[i][j] == 2) {
                    System.out.print("Qu▓");
                } else if (field[i][j] == 3) {
                    System.out.print("Ro▓");
                } else if (field[i][j] == 4) {
                    System.out.print("Bi▓");
                } else if (field[i][j] == 5) {
                    System.out.print("Kn▓");
                }
            } else {
                System.out.print("▓▓▓");
            }

        }
        System.out.println("│");
    }

    private static void img2(int i, int[][] field) {
        for (int j = 0; j < 8; j++) {
            if (j % 2 != 0) {System.out.print("│ ");}
            else if (j % 2 == 0) {System.out.print("│▓");}
            if (field[i][j] != 0 && j % 2 == 0) {
                if (field[i][j] == 1) {
                    System.out.print("Ki▓");
                } else if (field[i][j] == 2) {
                    System.out.print("Qu▓");
                } else if (field[i][j] == 3) {
                    System.out.print("Ro▓");
                } else if (field[i][j] == 4) {
                    System.out.print("Bi▓");
                } else if (field[i][j] == 5) {
                    System.out.print("Kn▓");
                }
            } else if (j % 2 == 0) {
                System.out.print("▓▓▓");
            } else if (field[i][j] != 0 && j % 2 != 0) {
                if (field[i][j] == 1) {
                    System.out.print("Ki ");
                } else if (field[i][j] == 2) {
                    System.out.print("Qu ");
                } else if (field[i][j] == 3) {
                    System.out.print("Ro ");
                } else if (field[i][j] == 4) {
                    System.out.print("Bi ");
                } else if (field[i][j] == 5) {
                    System.out.print("Kn ");
                }
            } else {
                System.out.print("   ");
            }
        }
        System.out.println("│");
    }
}