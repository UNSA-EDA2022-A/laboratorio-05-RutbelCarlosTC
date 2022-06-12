package com.example.project;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {
        Exercise1 obj = new Exercise1();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            System.out.println(obj.esBalanceado(s));
        }
    }

    public boolean esBalanceado(String s) {
        if(s.equals(""))
            return true;
        MyStack<Character> stack = new LinkedListStack<>();
        HashMap<Character,Character> corchetes = new HashMap<Character,Character>();
        corchetes.put('}', '{');
        corchetes.put(']', '[');
        corchetes.put(')', '(');
        char[] ch = s.toCharArray();
        for (int i = 0;i < ch.length; i++) {
            if(ch[i] =='{' || ch[i]=='[' || ch[i]=='('){
                stack.push(ch[i]);
            }
            else{
                if(stack.top() != null && stack.top().equals(corchetes.get(ch[i])))
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
