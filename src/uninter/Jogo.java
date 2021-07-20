package uninter;

public class Jogo {
    private final String [] [] m = {
            {"1", "2", "3"},
            {"4", "5", "6"},
            {"7", "8", "9"}
    };

    public String show() {
        for (int li = 0; li < 3; li++) { // linhas
            for (int co = 0; co < 3; co++) {// colunas
                System.out.print("    "+ m[li] [co]);
            }
            System.out.println("\n"); // quebra linha toda vez que "li" for > 2
        }
        return null;
    } // ---------------------------------------------------

    public boolean validation(String position) {
        for (int li = 0; li < 3; li++) {
            for (int co = 0; co < 3; co++) {
                if (m[li][co].equals(position)) {
                    return true;
                }
            }
        }

        return false;
    } // -------------------------------------------------------

    public void move(String position, String player) {
        // Verifico o index da linha e coluna para trocar os numeros pelo (X ou O)
        if (position.equals("1")) {
            m[0][0] = player;
        } else if (position.equals("2")) {
            m[0][1] = player;
        } else if (position.equals("3")) {
            m[0][2] = player;
        } else if (position.equals("4")) {
            m[1][0] = player;
        } else if (position.equals("5")) {
            m[1][1] = player;
        } else if (position.equals("6")) {
            m[1][2] = player;
        } else if (position.equals("7")) {
            m[2][0] = player;
        } else if (position.equals("8")) {
            m[2][1] = player;
        } else if (position.equals("9")) {
            m[2][2] = player;
        }
    } // ---------------------------------------------------------

    public String victory(int plays) {
        String[] T = new String[8]; // porque são 8 possibilidades de vitoria
        String winner = "null";
        if (plays == 9) {
            winner = "EMPATE";
        }
        // linhas
        T[0] = m[0][0] + m[0][1] + m[0][2];
        T[1] = m[1][0] + m[1][1] + m[1][2];
        T[2] = m[2][0] + m[2][1] + m[2][2];

        // vertical
        T[3] = m[0][0] + m[1][0] + m[2][0];
        T[4] = m[0][1] + m[1][1] + m[2][1];
        T[5] = m[0][2] + m[1][2] + m[2][2];

        // diagonais
        T[6] = m[0][0] + m[1][1] + m[2][2];
        T[7] = m[0][2] + m[1][1] + m[2][0];

        for (String s : T) {
            if (s.equals("XXX")) {
                winner = "Jogador 1";
            } else if (s.equals("OOO")) {
                winner = "Jogador 2";
            }
        }

        return winner;
    }
}
