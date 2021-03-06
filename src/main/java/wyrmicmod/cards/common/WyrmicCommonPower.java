package wyrmicmod.cards.common;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import basemod.abstracts.CustomCard;
import wyrmicmod.WyrmicMod;
import wyrmicmod.patches.AbstractCardEnum;
import wyrmicmod.powers.CommonPower;

public class WyrmicCommonPower extends CustomCard {

    /*
     * Wiki-page: https://github.com/daviscook477/BaseMod/wiki/Custom-Cards
     *
     * In order to understand how image paths work, go to wyrmicmod/WyrmicMod.java,
     * Line ~140 (Image path section).
     *
     * Hold Place Gain 1(2) Keywords(s).
     */

    // TEXT DECLARATION

    public static final String ID = wyrmicmod.WyrmicMod.makeID("WyrmicCommonPower");
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);

    public static final String IMG = "WyrmicModResources/images/cards/Power.png";

    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;

    // /TEXT DECLARATION/

    // STAT DECLARATION

    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.SELF;
    private static final CardType TYPE = CardType.POWER;
    public static final CardColor COLOR = AbstractCardEnum.WYRMIC_GREY;

    private static final int COST = 1;
    private static final int MAGIC = 1;
    private static final int UPGRADE_MAGIC = 1;

    public static final Logger logger = LogManager.getLogger(WyrmicMod.class.getName());

    // Hey want a second magic/damage/block/unique number??? Great!
    // Go check out WyrmicAttackWithVariable and
    // wyrmicmod.variable.WyrmicCustomVariable
    // that's how you get your own custom variable that you can use for anything you
    // like.
    // Feel free to explore other mods to see what variabls they personally have and
    // create your own ones.

    // /STAT DECLARATION/

    public WyrmicCommonPower() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        magicNumber = baseMagicNumber = MAGIC;
    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager
                .addToBottom(new ApplyPowerAction(p, p, new CommonPower(p, p, magicNumber), magicNumber));
    }

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeMagicNumber(UPGRADE_MAGIC);
            rawDescription = UPGRADE_DESCRIPTION;
            initializeDescription();
        }
    }
}