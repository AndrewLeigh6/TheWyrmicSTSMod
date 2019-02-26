package wyrmicmod.cards.special;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

import wyrmicmod.cards.AbstractWyrmicCard;
import wyrmicmod.patches.AbstractCardEnum;

abstract class AbstractWyrmicDrakeAspect extends AbstractWyrmicCard {

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
    private static final CardColor COLOR = AbstractCardEnum.WYRMIC_GREY;

    private static final int COST = 0;

    private static final int BLOCK = 10;
    private static final int UPGRADE_PLUS_BLOCK = 5;

    public int strength_gain = 0;
    public int upgrade_strength_gain = 0;
    public int dex_gain = 0;
    public int upgrade_dex_gain = 0;

    public AbstractWyrmicDrakeAspect(int strength_gain, int upgrade_strength_gain, int dex_gain, int upgrade_dex_gain) {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);

        baseBlock = BLOCK;
        magicNumber = baseMagicNumber = strength_gain;
        wyrmicSecondMagicNumber = wyrmicBaseSecondMagicNumber = dex_gain;

        this.strength_gain = strength_gain;
        this.upgrade_strength_gain = upgrade_strength_gain;
        this.dex_gain = dex_gain;
        this.upgrade_dex_gain = upgrade_dex_gain;

    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager
                .addToBottom(new com.megacrit.cardcrawl.actions.common.GainBlockAction(p, p, block));
        AbstractDungeon.actionManager.addToBottom(new com.megacrit.cardcrawl.actions.common.ApplyPowerAction(p, p,
                new StrengthPower(p, this.magicNumber), this.magicNumber));
        AbstractDungeon.actionManager.addToBottom(new com.megacrit.cardcrawl.actions.common.ApplyPowerAction(p, p,
                new DexterityPower(p, wyrmicSecondMagicNumber), wyrmicSecondMagicNumber));
    }

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeBlock(UPGRADE_PLUS_BLOCK);
            upgradeMagicNumber(upgrade_strength_gain);
            upgradeWyrmicSecondMagicNumber(upgrade_dex_gain);
            rawDescription = UPGRADE_DESCRIPTION;
            initializeDescription();
        }
    }
}