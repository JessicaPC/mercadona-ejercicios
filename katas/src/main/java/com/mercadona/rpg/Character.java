package com.mercadona.rpg;

import lombok.Data;

@Data
public class Character {
    private int health;
    private int level;
    private boolean alive;

    public Character() {
        this.health = 1000;
        this.level = 1;
        this.alive = true;
    }

    public void doDamage(double damage, Character character){
        if (this!= character){
            if (character.getLevel()>=5 || character.getLevel()>level){
                double percent = 0.5;
                int damageCopy = damage;
                damage = damage+(damageCopy*percent);
            }
            character.setHealth(character.getHealth()-damage);
            if (character.getHealth()<0){
                character.setHealth(0);
                character.setAlive(false);
            }
        }
    }

    public void doHeal(int heal, Character character){
        if (this==character){
            if (alive){
                if (health<1000){
                    health = health+heal;
                }else if (health==1000){
                    health = 1000;
                }
            }else{
                health = 0;
            }
        }
    }

}
