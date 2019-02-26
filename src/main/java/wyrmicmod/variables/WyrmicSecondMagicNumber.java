package wyrmicmod.variables;

import basemod.abstracts.DynamicVariable;
import com.megacrit.cardcrawl.cards.AbstractCard;
import wyrmicmod.cards.AbstractWyrmicCard;

import static wyrmicmod.WyrmicMod.makeID;

public class WyrmicSecondMagicNumber extends DynamicVariable {

    // For in-depth comments, check the other variable(WyrmicCustomVariable). It's
    // nearly identical.

    @Override
    public String key() {
        return makeID("theWyrmic:SecondMagic");
    }

    @Override
    public boolean isModified(AbstractCard card) {
        return ((AbstractWyrmicCard) card).isWyrmicSecondMagicNumberModified;

    }

    @Override
    public int value(AbstractCard card) {
        return ((AbstractWyrmicCard) card).wyrmicSecondMagicNumber;
    }

    @Override
    public int baseValue(AbstractCard card) {
        return ((AbstractWyrmicCard) card).wyrmicBaseSecondMagicNumber;
    }

    @Override
    public boolean upgraded(AbstractCard card) {
        return ((AbstractWyrmicCard) card).upgradedWyrmicSecondMagicNumber;
    }
}