package cn.com.cdgame.mrpg.abst;

import java.util.List;

/**
 *
 * Author：陈东
 * Time：2017/7/6 - 下午3:52
 * Notes:友善值、亲密度
 *
 * 会受情绪影响（直接加减情绪数值）
 */
public class Friendliness   {

    int value; //数值
    List<NPCFriendliness>  npcFriendlinesses ;

    /**
     * 对其他NPC的亲密度
     */
    public static class NPCFriendliness {
        int value; //数值
        String formId; //对象npc

    }





}



