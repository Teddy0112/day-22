class ATM {

    private long[] notes;
    private final int[] value = {20, 50, 100, 200, 500};

    public ATM() {
        notes = new long[5];
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < 5; i++) {
            notes[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        int[] ans = new int[5];
        long[] temp = notes.clone();

        for (int i = 4; i >= 0; i--) {
            long take = Math.min(temp[i], amount / value[i]);
            ans[i] = (int) take;
            amount -= take * value[i];
            temp[i] -= take;
        }

        if (amount != 0) {
            return new int[]{-1};
        }

        notes = temp;
        return ans;
    }
}
