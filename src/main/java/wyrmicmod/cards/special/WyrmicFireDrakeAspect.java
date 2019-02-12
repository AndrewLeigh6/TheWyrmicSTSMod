package wyrmicmod.cards.special;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import basemod.abstracts.CustomCard;
import wyrmicmod.WyrmicMod;
import wyrmicmod.patches.AbstractCardEnum;

public class WyrmicFireDrakeAspect extends CustomCard {

    // TEXT DECLARATION

    public static final String ID = wyrmicmod.WyrmicMod.makeID("WyrmicFireDrakeAspect");
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);

    public static final String IMG = "WyrmicModResources/images/cards/FireDrakeAspect.png";

    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;

    // /TEXT DECLARATION/

    // STAT DECLARATION

    private static final CardRarity RARITY = CardRarity.BASIC;
    private static final CardTarget TARGET = CardTarget.SELF;
    private static final CardType TYPE = CardType.POWER;
    public static final CardColor COLOR = AbstractCardEnum.WYRMIC_GREY;

    private static final int COST = 0;
    private static final int STRENGTH_GAIN = 2;
    private static final int UPGRADE_STRENGTH_GAIN = 2;

    public static final Logger logger = LogManager.getLogger(WyrmicMod.class.getName());

    // /STAT DECLARATION/

    public WyrmicFireDrakeAspect() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        magicNumber = baseMagicNumber = STRENGTH_GAIN;
    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new com.megacrit.cardcrawl.actions.common.ApplyPowerAction(p, p,
                new StrengthPower(p, this.magicNumber), this.magicNumber));
    }

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeMagicNumber(UPGRADE_STRENGTH_GAIN);
            rawDescription = UPGRADE_DESCRIPTION;
            initializeDescription();
        }
    }
}