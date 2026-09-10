package com.mycompany.actividad3ed;

public class SubsetSumSolver {

    public boolean exists(int[] set, int n, int target) {

        if (target == 0) {
            return true;
        }

        if (n == 0) {
            return false;
        }

       
        if (set[n - 1] > target) {
            return exists(set, n - 1, target);
        }

        return exists(set, n - 1, target)
            || exists(set, n - 1, target - set[n - 1]);
    }
}
