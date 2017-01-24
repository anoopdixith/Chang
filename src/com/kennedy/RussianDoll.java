package com.kennedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by adixith on 12/19/16.
 */
public class RussianDoll {
    public class WidthHeight {
        int width;
        int height;
        public WidthHeight(int width, int height) {
            this.height = height;
            this.width = width;
        }
    }
    public static void main(String args[]) {
        WidthHeight[] envelopes = new WidthHeight[]{new RussianDoll(). new WidthHeight(5,4),
                                                    new RussianDoll(). new WidthHeight(6,4),
                                                    new RussianDoll(). new WidthHeight(6,7),
                                                    new RussianDoll(). new WidthHeight(2,3)
                                                    };
        int compression = new RussianDoll().findCompression(envelopes);
        System.out.println(compression);
    }

    private int findCompression(WidthHeight[] envelopes) {
        if(envelopes == null ||
                envelopes.length ==0 ||
                envelopes.length == 1)
            return 0;
        Arrays.sort(envelopes, new Comparator<WidthHeight>() {
            @Override
            public int compare(WidthHeight o1, WidthHeight o2) {
                if (o1.width == o2.width) {
                    return o2.height - o1.height;
                } else {
                    return o1.width - o2.width;
                }
            }
        });

        //printEnvelopes(envelopes);
        int dp[] = new int[envelopes.length];
        int compression = 0;
        for(WidthHeight e: envelopes) {
            int index = Arrays.binarySearch(dp, 0, compression,e.height);



        }
        return compression;
    }

    private void printEnvelopes(WidthHeight[] envelopes) {
        for(WidthHeight e:envelopes) {
            System.out.println("(" + e.width + "," + e.height + ")");
        }
    }


}
