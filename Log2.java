public class Log2 {
    int[] tab32 = {0,  9,  1, 10, 13, 21,  2, 29,
       11, 14, 16, 18, 22, 25,  3, 30,
        8, 12, 20, 28, 15, 17, 24,  7,
       19, 27, 23,  6, 26,  5,  4, 31};
   
   int log2_32 (int value) {
       value |= value >> 1;
       value |= value >> 2;
       value |= value >> 4;
       value |= value >> 8;
       value |= value >> 16;
       int h = 0x07C4ACDD;
       int i = (int)(value*h) >> 27;
       i = i & -i;
       return tab32[i];
   }
}