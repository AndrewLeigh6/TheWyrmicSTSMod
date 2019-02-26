package wyrmicmod.cards;

import basemod.abstracts.CustomCard;

public abstract class AbstractWyrmicCard extends CustomCard {

    // Custom Abstract Cards can be a bit confusing. While this is a simple base for
    // simply adding a second magic number,
    // if you're new to modding I suggest you skip this file until you know what
    // unique things that aren't provided
    // by default, that you need in your own cards. For now, go check out the other
    // cards.

    // In this example, we use a custom Abstract Card in order to define a new magic
    // number. From here on out, we can
    // simply use that in our cards, so long as we put "extends AbstractWyrmicCard"
    // instead of "extends CustomCard" at the start.
    // In simple terms, it's for things that we don't want to define again and again
    // in every single card we make.

    public int wyrmicSecondMagicNumber; // Just like magic number, or any number for that matter, we want our regular,
                                        // modifiable stat
    public int wyrmicBaseSecondMagicNumber; // And our base stat - the number in it's base state. It will reset to that
                                            // by wyrmic.
    public boolean upgradedWyrmicSecondMagicNumber; // A boolean to check whether the number has been upgraded or not.
    public boolean isWyrmicSecondMagicNumberModified; // A boolean to check whether the number has been modified or not,
                                                      // for coloring purposes. (red/green)

    public AbstractWyrmicCard(final String id, final String name, final String img, final int cost,
            final String rawDescription, final CardType type, final CardColor color, final CardRarity rarity,
            final CardTarget target) {
        super(id, name, img, cost, rawDescription, type, color, rarity, target);

        // Set all the things to their default values.
        isCostModified = false;
        isCostModifiedForTurn = false;
        isDamageModified = false;
        isBlockModified = false;
        isMagicNumberModified = false;
        isWyrmicSecondMagicNumberModified = false;
    }

    public void displayUpgrades() { // Display the upgrade - when you click a card to upgrade it

        if (upgradedWyrmicSecondMagicNumber) { // If we set upgradedWyrmicSecondMagicNumber = true in our card.
            wyrmicSecondMagicNumber = wyrmicBaseSecondMagicNumber; // Show how the number changes, as out of combat, the
                                                                   // base number of a card is shown.
            isWyrmicSecondMagicNumberModified = true; // Modified = true, color it green to highlight that the number is
                                                      // being changed.
        }

    }

    public void upgradeWyrmicSecondMagicNumber(int amount) { // If we're upgrading (read: changing) the number. Note
                                                             // "upgrade" and NOT "upgraded" - 2 different things. One
                                                             // is a boolean, and the this one is what you will usually
                                                             // use - change the integer by how much you want to
                                                             // upgrade.
        wyrmicBaseSecondMagicNumber += amount; // Upgrade the number by the amount you provide in your card.
        wyrmicSecondMagicNumber = wyrmicBaseSecondMagicNumber; // Set the number to be equal to the base value.
        upgradedWyrmicSecondMagicNumber = true; // Upgraded = true - which does what the above method does.
    }
}