package com.example.project;

import java.util.Scanner;
import java.util.ArrayList;

public class Exercise2 {
    public static void main(String[] args) {
        Exercise2 obj = new Exercise2();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            System.out.println(obj.existenDuplicados(s));
        }
    }

    public boolean existenDuplicados(String str) {
        MyStack<Character> stack = new LinkedListStack<>();
        char[] ch = str.toCharArray();
        ArrayList<Character> operadores = new ArrayList<Character>();
        operadores.add('+');
        operadores.add('-');
        for (int i = 0;i < ch.length; i++) {
            if(ch[i] == '(' || operadores.contains(ch[i]))
                stack.push(ch[i]);
            if(ch[i] == ')'){
                if(operadores.contains(stack.top()))
                    stack.pop();
                if(stack.top() == '(')
                    stack.pop();
                if(!stack.isEmpty() && stack.top() == '(' && ch[i+1] == ')'){
                    return true;
                }
            }
        }
        return false;
    }
}
