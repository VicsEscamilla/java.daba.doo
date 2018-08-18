class MatrixProduct {

    public static Integer[][] matrixProduct(Integer[][] a, Integer[][] b) {
        Integer[][] c = new Integer[a.length][a.length];

        for (int i=0; i<a.length; i++) {
            for (int j=0; j<b[0].length; j++) {
                int count = 0;
                for (int k=0; k<a[0].length; k++) {
                    count += a[i][k] * b[k][j];
                }
                c[i][j] = count;
            }
        }

        return c;
    }

    public static void main(String[] args) {
        Integer[][] a = {
            {1, 0, 1},
            {0, 1, 2}
        };

        Integer[][] b = {
            {3,  5},
            {-1, 0},
            {2, -1}
        };

        Integer[][] c = matrixProduct(a, b);

        for (int i=0; i<c.length; i++) {
            for (int j=0; j<c[0].length; j++) {
                System.out.print(c[i][j]);
                System.out.print(",");
            }
            System.out.println();
        }
    }
}
