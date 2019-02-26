package wyrmicmod.cards.special;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import wyrmicmod.WyrmicMod;

public class WyrmicFireDrakeAspect extends AbstractWyrmicDrakeAspect {

    public static final String ID = WyrmicMod.makeID("WyrmicFireDrakeAspect");

    public static final String IMG = "WyrmicModResources/images/cards/WyrmicFireDrakeAspect.png";

    // STAT DECLARATION

    public static int STRENGTH_GAIN = 2;
    public static int UPGRADE_STRENGTH_GAIN = 2;
    public static int DEX_GAIN = -1;
    public static int UPGRADE_DEX_GAIN = -1;

    // /STAT DECLARATION/

    public WyrmicFireDrakeAspect() {
        super(STRENGTH_GAIN, UPGRADE_STRENGTH_GAIN, DEX_GAIN, UPGRADE_DEX_GAIN);
    }

    public void upgrade() {
        super.upgrade();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);
    }

}