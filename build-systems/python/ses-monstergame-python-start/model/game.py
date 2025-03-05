import random

class Monster:
    def __init__(self, hp):
        self.hp = hp

class Player:
    def __init__(self, hp):
        self.hp = hp

class Potion:
    @staticmethod
    def drink(player, monster):
        outcome = random.randint(0, 99)
        if outcome < 10:
            player.hp += 4
            print("De potion is super krachtig! +4 HP!")
        elif outcome < 20:
            monster.hp += 2
            print("Oeps! Je hebt het monster genezen! +2 HP voor het monster!")
        elif outcome < 30:
            player.hp -= 2
            print("De potion was giftig! -2 HP!")
        else:
            player.hp += 2
            print("De potion werkt! +2 HP!")