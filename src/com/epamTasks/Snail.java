package com.epamTasks;

import java.util.Scanner;
    public class Snail {
        public static void main(String[] args) {
            /*
                Write a program that reads a,b and h (line by lyne in this order) and prints
                the number of days for which the snail reach the top of the tree.
                a - feet that snail travels up each day, b - feet that slides down each night, h - height of the tree
            */

            Scanner scanner = new Scanner(System.in);
            System.out.println("Travels up:");
            int travelsUp = scanner.nextInt();          //a
            System.out.println("Slides down:");
            int slidesDown = scanner.nextInt();         //b
            System.out.println("Height:");
            int treeHeight = scanner.nextInt();         //h

            int currentHeight = 0;
            int daysSum;
            if (travelsUp <= slidesDown && travelsUp < treeHeight) {
                System.out.println("Impossible");
            } else {
                for (daysSum = 1; ; daysSum++) {
                    currentHeight += travelsUp;
                    if (currentHeight >= treeHeight) {
                        System.out.println("Days for reach the top - " + daysSum);
                        break;
                    }
                    currentHeight -= slidesDown;
                }
            }
        }
    }
