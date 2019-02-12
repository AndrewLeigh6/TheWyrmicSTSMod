package wyrmicmod;

import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.helpers.CardHelper;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.localization.CharacterStrings;
import com.megacrit.cardcrawl.localization.OrbStrings;
import com.megacrit.cardcrawl.localization.PotionStrings;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.localization.RelicStrings;
import com.megacrit.cardcrawl.unlock.UnlockTracker;

import basemod.BaseMod;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.EditCharactersSubscriber;
import basemod.interfaces.EditKeywordsSubscriber;
import basemod.interfaces.EditRelicsSubscriber;
import basemod.interfaces.EditStringsSubscriber;
import basemod.interfaces.PostInitializeSubscriber;

import wyrmicmod.cards.*;
import wyrmicmod.cards.basic.*;
import wyrmicmod.cards.common.*;
import wyrmicmod.cards.uncommon.*;
import wyrmicmod.cards.rare.*;
import wyrmicmod.characters.TheWyrmic;
import wyrmicmod.patches.AbstractCardEnum;
import wyrmicmod.patches.TheWyrmicEnum;
import wyrmicmod.relics.PlaceholderRelic;
import wyrmicmod.relics.PlaceholderRelic2;

@SpireInitializer
public class WyrmicMod
                implements EditCardsSubscriber, EditRelicsSubscriber, EditStringsSubscriber, EditCharactersSubscriber {

        // =============== INPUT TEXTURE LOCATION =================

        // Colors (RGB)
        // Character Color
        public static final Color WYRMIC_GREY = CardHelper.getColor(64.0f, 70.0f, 70.0f);

        // Card backgrounds - The actual rectangular card.
        private static final String ATTACK_WYRMIC_GREY = "WyrmicModResources/images/512/bg_attack_wyrmic_grey.png";
        private static final String SKILL_WYRMIC_GREY = "WyrmicModResources/images/512/bg_skill_wyrmic_grey.png";
        private static final String POWER_WYRMIC_GREY = "WyrmicModResources/images/512/bg_power_wyrmic_grey.png";
        private static final String ENERGY_ORB_WYRMIC_GREY = "WyrmicModResources/images/512/card_wyrmic_grey_orb.png";
        private static final String CARD_ENERGY_ORB = "WyrmicModResources/images/512/card_small_orb.png";

        private static final String ATTACK_WYRMIC_GREY_PORTRAIT = "WyrmicModResources/images/1024/bg_attack_wyrmic_grey.png";
        private static final String SKILL_WYRMIC_GREY_PORTRAIT = "WyrmicModResources/images/1024/bg_skill_wyrmic_grey.png";
        private static final String POWER_WYRMIC_GREY_PORTRAIT = "WyrmicModResources/images/1024/bg_power_wyrmic_grey.png";
        private static final String ENERGY_ORB_WYRMIC_GREY_PORTRAIT = "WyrmicModResources/images/1024/card_wyrmic_grey_orb.png";

        // Character assets
        private static final String THE_WYRMIC_BUTTON = "WyrmicModResources/images/charSelect/WyrmicCharacterButton.png";
        private static final String THE_WYRMIC_PORTRAIT = "WyrmicModResources/images/charSelect/WyrmicCharacterPortraitBG.png";

        public static final String THE_WYRMIC_MAIN = "WyrmicModResources/images/char/WyrmicCharacter/main.png";
        public static final String THE_WYRMIC_SHOULDER_1 = "WyrmicModResources/images/char/WyrmicCharacter/shoulder.png";
        public static final String THE_WYRMIC_SHOULDER_2 = "WyrmicModResources/images/char/WyrmicCharacter/shoulder2.png";
        public static final String THE_WYRMIC_CORPSE = "WyrmicModResources/images/char/WyrmicCharacter/corpse.png";

        // Mod Badge - A small icon that appears in the mod settings menu next to your
        // mod.
        public static final String BADGE_IMAGE = "WyrmicModResources/images/Badge.png";

        // Atlas and JSON files for the Animations
        // public static final String THE_WYRMIC_SKELETON_ATLAS =
        // "WyrmicModResources/images/char/WyrmicCharacter/skeleton.atlas";
        // public static final String THE_WYRMIC_SKELETON_JSON =
        // "WyrmicModResources/images/char/WyrmicCharacter/skeleton.json";

        // =============== /INPUT TEXTURE LOCATION/ =================

        public WyrmicMod() {

                BaseMod.subscribe(this);

                BaseMod.addColor(AbstractCardEnum.WYRMIC_GREY, WYRMIC_GREY, WYRMIC_GREY, WYRMIC_GREY, WYRMIC_GREY,
                                WYRMIC_GREY, WYRMIC_GREY, WYRMIC_GREY, ATTACK_WYRMIC_GREY, SKILL_WYRMIC_GREY,
                                POWER_WYRMIC_GREY, ENERGY_ORB_WYRMIC_GREY, ATTACK_WYRMIC_GREY_PORTRAIT,
                                SKILL_WYRMIC_GREY_PORTRAIT, POWER_WYRMIC_GREY_PORTRAIT, ENERGY_ORB_WYRMIC_GREY_PORTRAIT,
                                CARD_ENERGY_ORB);

                System.out.println(AbstractCardEnum.WYRMIC_GREY.toString());

        }

        public static void initialize() {
                new WyrmicMod();
        }

        @Override
        public void receiveEditCharacters() {

                BaseMod.addCharacter(new TheWyrmic("the Wyrmic", TheWyrmicEnum.THE_WYRMIC), THE_WYRMIC_BUTTON,
                                THE_WYRMIC_PORTRAIT, TheWyrmicEnum.THE_WYRMIC);
        }

        @Override
        public void receiveEditStrings() {
                // CardStrings
                BaseMod.loadCustomStringsFile(CardStrings.class,
                                "WyrmicModResources/localization/eng/WyrmicMod-Card-Strings.json");

                // PowerStrings
                BaseMod.loadCustomStringsFile(PowerStrings.class,
                                "WyrmicModResources/localization/eng/WyrmicMod-Power-Strings.json");

                // RelicStrings
                BaseMod.loadCustomStringsFile(RelicStrings.class,
                                "WyrmicModResources/localization/eng/WyrmicMod-Relic-Strings.json");

                // PotionStrings
                BaseMod.loadCustomStringsFile(PotionStrings.class,
                                "WyrmicModResources/localization/eng/WyrmicMod-Potion-Strings.json");

                // CharacterStrings
                BaseMod.loadCustomStringsFile(CharacterStrings.class,
                                "WyrmicModResources/localization/eng/WyrmicMod-Character-Strings.json");

                // OrbStrings
                BaseMod.loadCustomStringsFile(OrbStrings.class,
                                "WyrmicModResources/localization/eng/WyrmicMod-Orb-Strings.json");
        }

        @Override
        public void receiveEditRelics() {
                BaseMod.addRelicToCustomPool(new PlaceholderRelic(), AbstractCardEnum.WYRMIC_GREY);
                BaseMod.addRelicToCustomPool(new PlaceholderRelic2(), AbstractCardEnum.WYRMIC_GREY);
        }

        @Override
        public void receiveEditCards() {

                // Add the cards
                BaseMod.addCard(new WyrmicBasicAttack());
                BaseMod.addCard(new WyrmicBasicSkill());

                BaseMod.addCard(new WyrmicCommonAttack());
                BaseMod.addCard(new WyrmicCommonSkill());
                BaseMod.addCard(new WyrmicCommonPower());

                BaseMod.addCard(new WyrmicUncommonSkill());
                BaseMod.addCard(new WyrmicUncommonAttack());
                BaseMod.addCard(new WyrmicUncommonPower());

                BaseMod.addCard(new WyrmicRareAttack());
                BaseMod.addCard(new WyrmicRareSkill());
                BaseMod.addCard(new WyrmicRarePower());

                BaseMod.addCard(new WyrmicFlameStrike());
                BaseMod.addCard(new WyrmicFireball());
                BaseMod.addCard(new WyrmicDrakeAspect());

                // Unlock the cards
                UnlockTracker.unlockCard(WyrmicBasicAttack.ID);
                UnlockTracker.unlockCard(WyrmicBasicSkill.ID);

                UnlockTracker.unlockCard(WyrmicCommonAttack.ID);
                UnlockTracker.unlockCard(WyrmicCommonSkill.ID);
                UnlockTracker.unlockCard(WyrmicCommonPower.ID);

                UnlockTracker.unlockCard(WyrmicUncommonSkill.ID);
                UnlockTracker.unlockCard(WyrmicUncommonAttack.ID);
                UnlockTracker.unlockCard(WyrmicUncommonPower.ID);

                UnlockTracker.unlockCard(WyrmicRareAttack.ID);
                UnlockTracker.unlockCard(WyrmicRareSkill.ID);
                UnlockTracker.unlockCard(WyrmicRarePower.ID);

                UnlockTracker.unlockCard(WyrmicFlameStrike.ID);
                UnlockTracker.unlockCard(WyrmicFireball.ID);
                UnlockTracker.unlockCard(WyrmicDrakeAspect.ID);

        }

        // this adds "ModName:" before the ID of any card/relic/power etc.
        // in order to avoid conflicts if any other mod uses the same ID.
        public static String makeID(String idText) {
                return "TheWyrmic:" + idText;
        }
}
