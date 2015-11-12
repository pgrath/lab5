package com.example.pat.lab5;


//////////////////////////////////////////////////////////////
//
// This module contains a method that carries out the
// bubble sort on an array "a" of integers, where "n"
// is the number of data items (integers) currently in
// the array.
//
// Assumption: n > 1
//
// Author: M. Halper
//
//////////////////////////////////////////////////////////////

public class ArrayUtil {

    public static void sort(int[] a, int n)
    {
        boolean exchange_made;
        int num_items_to_visit;
        int last_marker;
        int i;
        int temp;

        // if the number of items is 0 or 1, then there's
        // nothing to do; otherwise, do the sorting

        if(n > 1)
        {
            // set the number of values (elmts) to visit on the first pass.
            // Note that it is actually one less than the total #
            // of data values since the comparison of the next-to-last
            // and last values occurs while visiting the next-to-last

            num_items_to_visit = n - 1;

            do
            {

                // no exchange has occurred yet on the current pass.
                // (We haven't scanned any values yet!)
                // Indicate this by lowering the "exchange_made" flag

                exchange_made = false;

                // the index of the last item to visit on this pass is
                // one less than the # to visit

                last_marker = num_items_to_visit - 1;

                // scan the values

                for(i = 0; i <= last_marker; i++)

                    if(a[i] > a[i+1])
                    {

                        // swap them

                        temp = a[i];
                        a[i] = a[i+1];
                        a[i+1] = temp;


                        // indicate that a swap has been made

                        exchange_made = true;

                    }

                // number of items to visit is now one less

                num_items_to_visit--;

            } while( exchange_made && (num_items_to_visit > 0) );

        }

    } // end sort

}