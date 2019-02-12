package wyrmicmod.characters;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.MathUtils;
import com.esotericsoftware.spine.AnimationState;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.helpers.ScreenShake;
import com.megacrit.cardcrawl.localization.CharacterStrings;
import com.megacrit.cardcrawl.screens.CharSelectInfo;
import com.megacrit.cardcrawl.unlock.UnlockTracker;

import basemod.abstracts.CustomPlayer;
import basemod.animations.SpriterAnimation;

import wyrmicmod.cards.*;
import wyrmicmod.cards.basic.*;
import wyrmicmod.cards.common.*;
import wyrmicmod.cards.uncommon.*;
import wyrmicmod.cards.rare.*;

import wyrmicmod.patches.AbstractCardEnum;
import wyrmicmod.relics.PlaceholderRelic;

import static wyrmicmod.WyrmicMod.*;

//Wiki-page https://github.com/daviscook477/BaseMod/wiki/Custom-Characters
//and https://github.com/daviscook477/BaseMod/wiki/Migrating-to-5.0
//All text (starting description and loadout, anything labeled TEXT[]) can be found in WyrmicMod-Character-Strings.json in the resources

public class TheWyrmic extends CustomPlayer {

    // =============== BASE STATS =================

    public static final int ENERGY_PER_TURN = 3;
    public static final int STARTING_HP = 75;
    public static final int MAX_HP = 75;
    public static final int STARTING_GOLD = 99;
    public static final int CARD_DRAW = 5;
    public static final int ORB_SLOTS = 0;

    // =============== /BASE STATS/ =================

    // =============== STRINGS =================

    private static final String ID = makeID("WyrmicCharacter");
    private static final CharacterStrings characterStrings = CardCrawlGame.languagePack.getCharacterString(ID);
    private static final String[] NAMES = characterStrings.NAMES;
    private static final String[] TEXT = characterStrings.TEXT;

    // =============== /STRINGS/ =================

    // =============== TEXTURES OF BIG ENERGY ORB ===============

    public static final String[] orbTextures = { "WyrmicModResources/images/char/WyrmicCharacter/orb/layer1.png",
            "WyrmicModResources/images/char/WyrmicCharacter/orb/layer2.png",
            "WyrmicModResources/images/char/WyrmicCharacter/orb/layer3.png",
            "WyrmicModResources/images/char/WyrmicCharacter/orb/layer4.png",
            "WyrmicModResources/images/char/WyrmicCharacter/orb/layer5.png",
            "WyrmicModResources/images/char/WyrmicCharacter/orb/layer6.png",
            "WyrmicModResources/images/char/WyrmicCharacter/orb/layer1d.png",
            "WyrmicModResources/images/char/WyrmicCharacter/orb/layer2d.png",
            "WyrmicModResources/images/char/WyrmicCharacter/orb/layer3d.png",
            "WyrmicModResources/images/char/WyrmicCharacter/orb/layer4d.png",
            "WyrmicModResources/images/char/WyrmicCharacter/orb/layer5d.png", };

    // =============== /TEXTURES OF BIG ENERGY ORB/ ===============

    // =============== CHARACTER CLASS START =================

    public TheWyrmic(String name, PlayerClass setClass) {
        super(name, setClass, orbTextures, "WyrmicModResources/images/char/WyrmicCharacter/orb/vfx.png", null,
                new SpriterAnimation("WyrmicModResources/images/char/WyrmicCharacter/Spriter/TheWyrmicAnimation.scml"));

        // =============== TEXTURES, ENERGY, LOADOUT =================

        initializeClass(THE_WYRMIC_MAIN, // required call to load textures and setup energy/loadout.
                // I left these in WyrmicMod.java (Ctrl+click them to see where they are,
                // Ctrl+hover to see what they read.)
                THE_WYRMIC_SHOULDER_1, // campfire pose
                THE_WYRMIC_SHOULDER_2, // another campfire pose
                THE_WYRMIC_CORPSE, // dead corpse
                getLoadout(), 20.0F, -10.0F, 220.0F, 290.0F, new EnergyManager(ENERGY_PER_TURN)); // energy manager

        // =============== /TEXTURES, ENERGY, LOADOUT/ =================

        // =============== ANIMATIONS =================

        // loadAnimation(THE_WYRMIC_SKELETON_ATLAS, THE_WYRMIC_SKELETON_JSON, 1.0f);
        // AnimationState.TrackEntry e = state.setAnimation(0, "animation", true);
        // e.setTime(e.getEndTime() * MathUtils.random());

        // =============== /ANIMATIONS/ =================

        // =============== TEXT BUBBLE LOCATION =================

        // =============== /TEXT BUBBLE LOCATION/ =================

    }

    // =============== /CHARACTER CLASS END/ =================

    // Starting description and loadout
    @Override
    public CharSelectInfo getLoadout() {
        return new CharSelectInfo(NAMES[0], TEXT[0], STARTING_HP, MAX_HP, ORB_SLOTS, STARTING_GOLD, CARD_DRAW, this,
                getStartingRelics(), getStartingDeck(), false);
    }

    // Starting Deck
    @Override
    public ArrayList<String> getStartingDeck() {
        ArrayList<String> retVal = new ArrayList<>();

        retVal.add(WyrmicBasicAttack.ID);
        retVal.add(WyrmicBasicAttack.ID);
        retVal.add(WyrmicBasicAttack.ID);
        retVal.add(WyrmicBasicAttack.ID);
        retVal.add(WyrmicBasicAttack.ID);

        retVal.add(WyrmicBasicSkill.ID);
        retVal.add(WyrmicBasicSkill.ID);
        retVal.add(WyrmicBasicSkill.ID);
        retVal.add(WyrmicBasicSkill.ID);
        retVal.add(WyrmicBasicSkill.ID);

        retVal.add(WyrmicFireball.ID);
        retVal.add(WyrmicFlameStrike.ID);
        retVal.add(WyrmicDrakeAspect.ID);
        return retVal;
    }

    // Starting Relics
    @Override
    public ArrayList<String> getStartingRelics() {
        ArrayList<String> retVal = new ArrayList<>();

        retVal.add(PlaceholderRelic.ID);

        UnlockTracker.markRelicAsSeen(PlaceholderRelic.ID);

        return retVal;
    }

    // Character Select screen effect
    @Override
    public void doCharSelectScreenSelectEffect() {
        CardCrawlGame.sound.playA("ATTACK_DAGGER_1", 1.25f); // Sound Effect
        CardCrawlGame.screenShake.shake(ScreenShake.ShakeIntensity.LOW, ScreenShake.ShakeDur.SHORT, false); // Screen
                                                                                                            // Effect
    }

    // Character Select on-button-press sound effect
    @Override
    public String getCustomModeCharacterButtonSoundKey() {
        return "ATTACK_DAGGER_1";
    }

    // Should return how much HP your maximum HP reduces by when starting a run at
    // Ascension 14 or higher. (ironclad loses 5, defect and silent lose 4 hp
    // respectively)
    @Override
    public int getAscensionMaxHPLoss() {
        return 0;
    }

    // Should return the card color enum to be associated with your character.
    @Override
    public AbstractCard.CardColor getCardColor() {
        return AbstractCardEnum.WYRMIC_GREY;
    }

    // Should return a color object to be used to color the trail of moving cards
    @Override
    public Color getCardTrailColor() {
        return wyrmicmod.WyrmicMod.WYRMIC_GREY;
    }

    // Should return a BitmapFont object that you can use to customize how your
    // energy is displayed from within the energy orb.
    @Override
    public BitmapFont getEnergyNumFont() {
        return FontHelper.energyNumFontRed;
    }

    // Should return class name as it appears in run history screen.
    @Override
    public String getLocalizedCharacterName() {
        return NAMES[0];
    }

    // The class name as it appears next to your player name in-game
    @Override
    public String getTitle(AbstractPlayer.PlayerClass playerClass) {
        return NAMES[1];
    }

    // Should return a new instance of your character, sending name as its name
    // parameter.
    @Override
    public AbstractPlayer newInstance() {
        return new TheWyrmic(name, chosenClass);
    }

    // Should return a Color object to be used to color the miniature card images in
    // run history.
    @Override
    public Color getCardRenderColor() {
        return wyrmicmod.WyrmicMod.WYRMIC_GREY;
    }

    // Should return a Color object to be used as screen tint effect when your
    // character attacks the heart.
    @Override
    public Color getSlashAttackColor() {
        return wyrmicmod.WyrmicMod.WYRMIC_GREY;
    }

    // Should return an AttackEffect array of any size greater than 0. These effects
    // will be played in sequence as your character's finishing combo on the heart.
    // Attack effects are the same as used in DamageAction and the like.
    @Override
    public AbstractGameAction.AttackEffect[] getSpireHeartSlashEffect() {
        return new AbstractGameAction.AttackEffect[] { AbstractGameAction.AttackEffect.BLUNT_HEAVY,
                AbstractGameAction.AttackEffect.BLUNT_HEAVY, AbstractGameAction.AttackEffect.BLUNT_HEAVY };
    }

    // Should return a string containing what text is shown when your character is
    // about to attack the heart. For example, the defect is "NL You charge your
    // core to its maximum..."
    @Override
    public String getSpireHeartText() {
        return TEXT[1];
    }

    // The vampire events refer to the base game characters as "brother", "sister",
    // and "broken one" respectively.This method should return a String containing
    // the full text that will be displayed as the first screen of the vampires
    // event.
    @Override
    public String getVampireText() {
        return TEXT[2];
    }

    @Override
    public AbstractCard getStartCardForEvent() {
        return new WyrmicBasicAttack();
    }

    // ================ /LOAD THE KEYWORDS/ ===================

}
