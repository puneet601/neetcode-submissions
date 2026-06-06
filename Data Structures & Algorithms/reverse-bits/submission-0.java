class Solution {
    public int reverseBits(int n) {
        int res = 0;
        int i = 0;
        int bits = 0;
        while(i<32){
            int ithBit = (n>>i) & 1;
            if(ithBit == 1)
            res = res | (1 << (31-i));
            i++;
        }
        return res;
    }
}
