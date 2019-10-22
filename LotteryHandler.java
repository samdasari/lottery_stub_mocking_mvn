/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.celestial.lotterystub.jmock;

import com.celestial.lotterystubmockingmvn.INumberGenerator;
import java.util.HashSet;

/**
 *
 * @author Selvyn
 */
public class LotteryHandler
{
    private final INumberGenerator    generator;
    static  public final   int LOTTERY_SIZE = 5;
    static  public final   int HIGHEST_NUMBER = 99;
    
    public  LotteryHandler( INumberGenerator generator )
    {
        this.generator = generator;
    }
    
    public  HashSet<Integer> GenerateRandomSet()
    {
        HashSet<Integer> result = new HashSet<>();
        
        while( result.size() < LOTTERY_SIZE )
        {
            int num = generator.generate(HIGHEST_NUMBER);
            result.add(num + 1);
        }
        
        return result;
    }
    
    public  String  format( HashSet<Integer> numbers )
    {
        StringBuilder result = new StringBuilder();
        int count = 0;
        for( Integer num : numbers )
        {
            result.append(num);
            count++;
            if( count < numbers.size() )
                result.append( " - ");
        }
        return result.toString();
    }
}
