
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eldar.bot_brains;
import com.eldar.Bot;

/** Author Bityulin Yuriy */
public class BotBrains_Yuriy implements BotBrain
{
    private Bot bot;
    DirectionOfBot Direction;

    public BotBrains_Yuriy()
    {
        Direction = new DirectionOfBot(0);
    }

    public void solveMaze(Bot curBot)
    {
        this.bot=curBot;

        while(!bot.isFinished())
            found_way();//обход лабиринта держась левой стороны

    }

    private void found_way() {
        //Используем алгоритм левой стены
        if(bot.checkDir(Direction.get_counterclockwise_rot()))
        {//если путь налево существует, то пооврачиваем и делаем шаг
            Direction.set_counterclockwise_rot();
            bot.moveInDir(Direction.get());
        }
        else if(bot.checkDir((Direction.get())))
        {//если путь прямо существует, то делаем шаг
            bot.moveInDir(Direction.get());
        }
        else if(bot.checkDir(Direction.get_clockwise_rot()))
        {//если путь направо существует, то пооврачиваем и делаем шаг
            Direction.set_clockwise_rot();
            bot.moveInDir(Direction.get());

        }
        else
        { //если путей нет, надо развернуться
            Direction.reverse_bot();
            bot.moveInDir(Direction.get());
        }

    }
}