package com.example.LongInt;

import java.util.Vector;

public class LongInt
{
    private Vector<Integer> num;		 //массив для цифр
    private int size;			 //размер массива
    private int sign;

    LongInt(int max)
    {
        num = new Vector<Integer>(max);
        for(int i = 0; i < max; ++i)
            num.add(0);
        size = max;
    }

    LongInt(String StrT)
    {
        Integer k;
    	size = StrT.length();
        num = new Vector<Integer>(size);
        for(int i = size-1; i >= 0; i--)
        {
            num.add(size-i-1, StrT.charAt(i) - 48);
        }
    }

    /////////////Сложение//////////////

    public LongInt Plus(LongInt num1)
    {
        int max, min;
        if(size > num1.size)
        {
            max = size;
            min = num1.size;
        }
        else
        {
            max = num1.size;
            min = size;
        }

        LongInt num3 = new LongInt(max+1);

        int trans = 0;
        for(int i = 0; i <= max; ++i)
        {
            int ai = 0, bi = 0, ci = 0;
            if(i < size)
            {
                ai = num.elementAt(i);
            }
            else
            {
                ai = 0;
            }

            if(i < num1.size)
            {
                bi = num1.num.elementAt(i);
            }
            else
            {
                bi = 0;
            }

            ci = (ai + bi + trans) % 10;
            trans = (ai + bi + trans) / 10;
            num3.num.setElementAt(ci, i);
        }
        if(num3.num.elementAt(max) == 0)
        {
            num3.size = max;
        }
        return num3;
    }

    /////////Умножение//////////////

    private LongInt MultiOnDigit(int d)
    {
        int max = size + 1, trans = 0;
        LongInt res = new LongInt(max);

        for(int i = 0; i < size; ++i)
        {
            int c = num.elementAt(i) * d + trans;
            res.num.setElementAt(c % 10, i);
            trans = c / 10;
        }
        if(trans != 0)
        {
            res.num.setElementAt(trans, size);
        }
        else
        {
            res.size--;
        }

        return res;
    }

    private LongInt MultiOnTenDeg(int i)
    {
        LongInt res = new LongInt(size + i);
        for(int j = 0;j < size; ++j)
            res.num.setElementAt(num.elementAt(j), i + j);
        return res;
    }

    public LongInt Multi(LongInt num1)
    {
        int max = size + num1.size;
        LongInt num3 = new LongInt(max);

        for(int i = 0; i < num1.size; ++i)
        {
            LongInt p_sum = MultiOnDigit(num1.num.elementAt(i)).MultiOnTenDeg(i);
            num3 = num3.Plus(p_sum);
        }

        while(num3.num.elementAt(num3.size - 1) == 0)
            num3.size--;
        return num3;
    }

    //////////////Вычитание////////////////

    public int Comparison(LongInt num1)
    {
        if(size > num1.size)
        {
            return 1;
        }
        else
        {
            if (size < num1.size)
            {
                return -1;
            }
            else
            {
                for(int i = size - 1;i <= 0;--i)
                {
                    int n = 0;
                    if(num.elementAt(i) > num1.num.elementAt(i))
                    {
                        return 1;
                    }
                    else
                    {
                        return -1;
                    }
                }
                return 0;
            }
        }
    }

    public LongInt Sub(LongInt num1)
    {
        int ci,ai,bi;
        LongInt num3 = new LongInt(size);
        for(int i = 0; i < size; ++i)
        {
            if(i < size)
            {
                ai = num.elementAt(i);
            }
            else
            {
                ai = 0;
            }
            if(i < num1.size)
            {
                bi = num1.num.elementAt(i);
            }
            else
            {
                bi = 0;
            }
            if(ai - bi >= 0)
            {
                ci = ai - bi;
            }
            else
            {
                ci = 10 + ai - bi;
                num.setElementAt(num.elementAt(i+1)-1,i+1);
            }
            num3.num.setElementAt(ci,i);
        }
        return num3;
    }

    public LongInt Subtraction(LongInt num1)
    {
        int comp = Comparison(num1);
        LongInt num3 = new LongInt(size);
        if(comp == 1)
        {
            num3 = Sub(num1);
        }
        else
        {
            if(comp == -1)
            {
                num3 = num1.Sub(this);
            }
        }
        return num3;
    }

    public void Show()
    {
        for(int i = size - 1; i >= 0; --i)
        {
            System.out.print(num.elementAt(i));
        }
        System.out.println();
    }
}
