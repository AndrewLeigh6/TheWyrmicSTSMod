package wyrmicmod.cards.basic;

import basemod.abstracts.CustomCard;
import basemod.helpers.ModalChoice;
import basemod.helpers.ModalChoiceBuilder;
import basemod.helpers.TooltipInfo;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.CardLibrary;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import wyrmicmod.patches.AbstractCardEnum;
import wyrmicmod.WyrmicMod;
import wyrmicmod.cards.special.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class WyrmicDrakeAspect extends CustomCard implements ModalChoice.Callback {
    public static final String ID = wyrmicmod.WyrmicMod.makeID("WyrmicDrakeAspect");
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);

    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;

    private static final CardRarity RARITY = CardRarity.BASIC;
    private static final CardTarget TARGET = CardTarget.NONE;
    private static final CardType TYPE = CardType.ATTACK;
    public static final CardColor COLOR = AbstractCardEnum.WYRMIC_GREY;

    private static final int COST = 0;
    private ModalChoice modal;

    private static final AbstractCard FireDrakeAspect = new WyrmicFireDrakeAspect();
    private static final AbstractCard ColdDrakeAspect = new WyrmicColdDrakeAspect();
    private static final AbstractCard VenomDrakeAspect = new WyrmicVenomDrakeAspect();

    public static final Logger logger = LogManager.getLogger(WyrmicMod.class.getName());

    public WyrmicDrakeAspect() {
        super(ID, NAME, null, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);

        this.exhaust = true;

        modal = new ModalChoiceBuilder().setCallback(this).setColor(COLOR).addOption(FireDrakeAspect)
                .addOption(ColdDrakeAspect).addOption(VenomDrakeAspect).create();
    }

    // Uses the titles and descriptions of the option cards as tooltips for this
    // card
    @Override
    public List<TooltipInfo> getCustomTooltips() {
        return modal.generateTooltips();
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        if (this.upgraded) {
            FireDrakeAspect.upgrade();
            ColdDrakeAspect.upgrade();
            VenomDrakeAspect.upgrade();
        }
        modal.open();
    }

    // This is called when one of the option cards us chosen
    @Override
    public void optionSelected(AbstractPlayer p, AbstractMonster m, int i) {
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
        }
    }

    @Override
    public AbstractCard makeCopy() {
        return new WyrmicDrakeAspect();
    }
}