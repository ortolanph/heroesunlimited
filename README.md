# Heroes Unlimited

## Main goal

Simple RPG to test Asynchronous Programming in Javascript and Java.

## Player Structure

```PlayableCharacter``` class:

| Attrbitute | Type | Initial Value | Description |
| --- |:---:|:---:| --- |
| id | ```Integer``` | | The Player's Id |
| name | ```String``` | | Player's name |
| gold | ```Long``` | 0 | Total gold amount |
| levelInfo | ```LevelInfo``` | see below | Level Information |
| playerClass | ```PlayerClass``` | see below | Player class information |
| playerRace | ```PlayerRace``` | see below | Player race information |
| life | ```SimpleAttribute``` | see below | Life attribute |
| mana | ```SimpleAttribute``` | see below | Mana attribute |
| attributes | ```Map<StructuralAttribute, Integer>``` | see below | Structural attributes calculated |
| equipment | ```Map<EquipmentType, Equipment>``` | see below | Players equipment |

```LevelInfo``` class:

| Attrbitute | Type | Initial Value | Description |
| --- |:---:|:---:| --- |
| level | ```Integer``` | 1 | Player's level |
| experience | ```Integer``` | 0 | Player's total experience |
| next | ```Integer``` | 1200 | Points to reach next level |

```PlayerClass``` enum:

| Attrbitute | Type | Initial Value | Description |
| --- |:---:|:---:| --- |
| name | ```String``` | see Classes section | The attribute name |
| modifier | ```AttributeModifier``` | see below | The attribute modifier |

```PlayerRace``` enum:

| Attrbitute | Type | Initial Value | Description |
| --- |:---:|:---:| --- |
| name | ```String``` | see Races section | The attribute name |
| gender | ```Gender``` | see below | The gender |
| modifier | ```AttributeModifier``` | see below | The attribute modifier |

```AttributeModifier``` class:

| Attrbitute | Type | Initial Value | Description |
| --- |:---:|:---:| --- |
| life | ```Integer``` | see Races section | Life points modifier |
| mana | ```Integer``` | see Races section | Mana points modifier |
| str | ```Integer``` | see Races section | Strength points modifier |
| dex | ```Integer``` | see Races section | Dexterity points modifier |
| int | ```Integer``` | see Races section | Intelligence points modifier |
| def | ```Integer``` | see Races section | Defense points modifier |

```Gender``` enum: 

| Attrbitute | Type | Initial Value | Description |
| --- |:---:|:---:| --- |
| name | ```String``` | see Races section | The gender name |

```SimpleAttribute``` class:

| Attrbitute | Type | Initial Value | Description |
| --- |:---:|:---:| --- |
| initial | ```Integer``` | | The initial value of the attribute |
| current | ```Integer``` | | The current value of the attribute |

```StructuralAttribute``` enum:

| Attrbitute | Type | Initial Value | Description |
| --- |:---:|:---:| --- |
| symbol | ```String``` | see Structural Attributes section | The structural attribute symbol |
| name | ```String``` | see Structural Attributes section | The structural attribute symbol |

```EquipmentType``` class:

| Attrbitute | Type | Initial Value | Description |
| --- |:---:|:---:| --- |
| name | ```String``` | see Equipment section | The Equipment name |

```Equipment``` class:

| Attrbitute | Type | Initial Value | Description |
| --- |:---:|:---:| --- |
| id | ```Integer``` | see Equipment sections | The equipment id |
| type | ```EquipmentType``` | see above | The equipment type |
| name | ```String``` | | The equipment name |
| modifier | ```AttributeModifier``` | see below | The attribute modifier |

## Attributes

Attributes can be simple or structural.

### Simple Attributes

| Name | Description |
| --- | --- |
| Life | Life points |
| Mana | Mana points to invoke magic |

To calculate the Simple Attributes:

```
Life = 2d20 + Class.life + Race.gender.life
Mana = 1d20 + Class.mana + Race.gender.mana
```

### Structural Attributes

| Name | Symbol | Description |
| ---  |:---:| --- |
| Strength | ```STR``` | How strong an attack can be |
| Dexterity | ```DEX``` | The ability to miss an attack |
| Intelligence | ```INT``` | Can be use to call a physical or magical critical hit |
| Defense | ```DEF``` | Can use to defend or lower the attack power |

To calculate the Structural Attributes:

```
s = class.s + race.gender.s + sum(equip.s)
```


## Classes

|  Class  |LIFE | MANA | STR | DEX | INT | DEF |
| ------- | ---:|  ---:| ---:| ---:| ---:| ---:|
| Cleric  |  +5 |  +15 |  +5 |  +5 | +15 |  +5 |
| Rogue   | +10 |   +5 | +10 | +15 | +10 | +10 |
| Warrior | +15 |   +5 | +15 |  +5 |  +5 | +15 |

## Races

| Race  | Gender | LIFE | MANA | STR | DEX | INT | DEF |
| ----- | ------ |  ---:|  ---:| ---:| ---:| ---:| ---:|
| Human | Male   |   +7 |   +5 |  +7 |  +5 |  +5 |  +7 |
|       | Female |   +5 |   +3 |  +5 |  +7 |  +5 |  +5 |
| Elf   | Male   |   +7 |   +5 |  +5 |  +7 |  +5 |  +5 |
|       | Female |   +5 |   +5 |  +5 |  +7 |  +5 |  +5 |
| Dwarf | Male   |   +7 |   +3 |  +7 |  +3 |  +3 |  +7 |
|       | Female |   +7 |   +3 |  +7 |  +3 |  +3 |  +7 |

## Equipment

| Type      |
| --------- |
| Weapon    |
| Shield    |
| Armor     |
| Boots     |
| Helmet    |
| Accessory |

### Weapons

|  #  | Name | STR | DEX | INT | DEF |
|:---:| ---- | ---:| ---:| ---:| ---:|
|  1  | Wood Sword | +3 | | | |
|  2  | Iron Sword | +5 | | | |
|  3  | Green Destiny | +9 | | | |
|  4  | Hrunting | +9 | +3 | | |
|  5  | Excalibur | +11 | | +3 | |

### Shields

|  #  | Name | STR | DEX | INT | DEF |
|:---:| ---- | ---:| ---:| ---:| ---:|
|  1  | Wood Shield | | | | +3 |
|  2  | Iron Shield | | | | +5 |
|  3  | Steel Sword | | | | +7 |
|  4  | Oakenshield | | +3 | | +9 |
|  5  | Mithril Shield | +11 | +5 | | +11 |

### Armors

|  #  | Name | STR | DEX | INT | DEF |
|:---:| ---- | ---:| ---:| ---:| ---:|
|  1  | Wood Armor | | | | +3 |
|  2  | Iron Armor | | | | +5 |
|  3  | Steel Armor | | | | +7 |
|  4  | Mithril Vest | | +3 | | +9 |
|  5  | Golden Armor | +3 | +5 | | +11 |

### Boots

|  #  | Name | STR | DEX | INT | DEF |
|:---:| ---- | ---:| ---:| ---:| ---:|
|  1  | Furry Boots | | +3 | |  |
|  2  | Leather Boots | | +5 | | |
|  3  | Steel Boots | | +7 | +3 | |
|  4  | Mithril Boots | | +9 | +5 | +3 |
|  5  | Dragon Boots | | +11 | +7 | |

### Helmet

|  #  | Name | STR | DEX | INT | DEF |
|:---:| ---- | ---:| ---:| ---:| ---:|
|  1  | Viking Helmet | +3 | | | +3 |
|  2  | Green Beret | | +3 | | +5 |
|  3  | Crusader Helmet | | | +3 | +7 |
|  4  | Mithril Helmet | | +5 | | +9 |
|  5  | Dragon Head | +5 | | +5 | +11 |

### Accessory

|  #  | Name | STR | DEX | INT | DEF |
|:---:| ---- | ---:| ---:| ---:| ---:|
|  1  | STR Pendant | +3 | | | |
|  2  | DEX Bracelet | | +3 | | | 
|  3  | INT Ribbon | | | +3 | |
|  4  | DEF Shoulder Pads | | | | +3 |
|  5  | Ring of Destiny | +5 | +5 | +5 | +5 |
|  6  | Smart Ring | -3 | -3 | +7 | -3 |
|  7  | Invisibility Ring | -3 | +7 | -3 | -3 |
|  8  | Ring of Fire | -7 | -3 | -3 | -3 |
|  9  | Energy Ring | -3 | -3 | -3 | -7 |

## Rest API

**Build a player**:

```
/api/players/name/{name}
```

Returns a named human warrior male player unequipped.

**Build a player with a class**

```
/api/players/name/{name}/class/{class}
```

Where ```class``` is:

* CLERIC
* ROGUE
* WARRIOR

Returns a named human male player with selected class unequipped.


**Build a player with a class, race and gender**

```
/api/players/name/{name}/class/{class}/race/{race}/gender/{gender}
```

Where ```class``` is:

* CLERIC
* ROGUE
* WARRIOR

Where ```race``` is:

* HUMAN
* ELF
* DWARF

Where ```gender``` is:

* MALE
* FEMALE

Returns a named player with selected class, race and gender unequipped.


**Equip**

```
/api/equipment/player/{id}/weapon/{weaponId}
/api/equipment/player/{id}/shield/{shieldId}
/api/equipment/player/{id}/armor/{armorId}
/api/equipment/player/{id}/boots/{bootsId}
/api/equipment/player/{id}/helmet/{helmetId}
/api/equipment/player/{id}/accessory/{accessoryId}
```

Where ```id``` is the created player id and ```{xId}``` is the equipment id according to previous sections.
