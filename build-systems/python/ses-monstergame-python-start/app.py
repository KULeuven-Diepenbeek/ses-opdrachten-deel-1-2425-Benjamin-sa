import random
import sys
from model.game import Player, Monster, Potion

def play_turn(player, monster, choice):
    monster_attack = random.randint(1, 4)  # Monster doet tussen 1 en 4 schade

    if choice == 1:
        attack_damage = random.randint(1, 2)  # 1 of 2 schade
        monster.hp -= attack_damage
        print(f"Je valt aan en doet {attack_damage} schade!")
    elif choice == 2:
        if random.randint(0, 99) < 80:
            monster_attack = 0
            print("Je blokkeert de aanval succesvol!")
        else:
            print("Je blokkeerpoging faalt!")
    elif choice == 3:
        Potion.drink(player, monster)
    else:
        print("Ongeldige keuze, probeer opnieuw!")
        return

    # Monster valt aan als het nog leeft
    if monster.hp > 0:
        player.hp -= monster_attack
        print(f"Het monster valt aan en doet {monster_attack} schade!")

def main():
    starting_hp = 10
    args = sys.argv
    if "--hp" in args:
        index = args.index("--hp")
        if index + 1 < len(args):
            try:
                starting_hp = int(args[index + 1])
            except ValueError:
                print("Ongeldige HP waarde, standaard 10 wordt gebruikt.")
    player = Player(starting_hp)
    monster = Monster(10)

    print("Welkom bij het gevechtsspel!")
    print(f"Jouw start HP is: {player.hp}")

    while player.hp > 0 and monster.hp > 0:
        print(f"\nJouw HP: {player.hp} | Monster HP: {monster.hp}")
        print("Kies een actie:")
        print("1. Aanvallen")
        print("2. Blokkeren")
        print("3. Lucky Potion drinken")
        try:
            keuze = int(input("Voer je keuze in: "))
        except ValueError:
            print("Ongeldige invoer, probeer opnieuw.")
            continue

        play_turn(player, monster, keuze)

    if player.hp > 0:
        print("\nGefeliciteerd! Je hebt het monster verslagen!")
    else:
        print("\nHelaas! Het monster heeft jou verslagen...")

if __name__ == '__main__':
    main()