import com.opt.base.BaseTest;
import com.opt.pages.HomepageObject;
import com.opt.pages.TermsAndConditionsPageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


/**
 * Created by alex.mihai on 11/6/2017.
 */
public class TermsAndConditionsTest extends BaseTest{
    @Test
    public void TermsAndConditionsTest() throws InterruptedException, IOException {
        HomepageObject homepage = new HomepageObject(driver);
        homepage.openHomePage();
        homepage.acceptPrompt();
        homepage.waitForHomepageToLoad();
        TermsAndConditionsPageObject termsPage = homepage.openTermsAndConditions();
        termsPage.waitForPageToLoad();
        String[] expectedConditions = {"This service is provided in Australia for Australian and New Zealand consumers.  Whilst every effort is made to ensure that other consumers " +
                "will receive the full membership experience, members residing outside Australia and New Zealand acknowledge and agree that they may not receive the full membership" +
                " experience that may be available in Australia.","The membership is valid for the lifetime of the OPTIFAST® VLCD™ membership site.  You can choose to opt out of your " +
                "membership before then. In the event that the site closes, the membership will end. ","We can suspend or discontinue the membership site at any time.   We do not need " +
                "to give you notice before suspending or discontinuing this site. ", "We may change these terms and conditions at any time.  Please refer to this page from time to time " +
                "to review these terms and any new information.", "All member details will be held in accordance with the Nestlé Privacy Policy, which can be accessed on this website."};
        String[] conditions = termsPage.buildArrayMemberText();
        org.junit.Assert.assertArrayEquals(expectedConditions, conditions);

        String[] expectedEngagements = {"We are committed to creating a community that encourages interaction and collaboration and also shows respect for others. We ask members of the " +
                "OPTIFAST® VLCD™ website to do their part by complying with these rules for posts, uploads, communications and general behaviour on this site.", "We value any feedback and " +
                "engagement so please let us know if you have any questions or concerns regarding the management of this forum.    In the spirit of openness, it’s worth highlighting that " +
                "if a post breaks these rules, it may be hidden or deleted without notification, but we also commit to not deleting posts which are challenging or questioning as long as " +
                "they are done in a constructive way and in line with the guidelines below:", "Keep it clean: no indecent or otherwise inappropriate posts or uploads.", "Play fair: no " +
                "defamatory, bullying, harassing, obscene, threatening, dangerous or abusive posts.", "Be respectful and kind: respect other people’s opinions and don’t attack people with" +
                " extreme or hurtful language or with a personal attack. It stops conversation and can hurt people.", "Stay on topic: no spam, good luck/chain posts, commercial/promotional " +
                "posts including any unsolicited or unauthorised advertising, nor repeated postings of unconstructive, inflammatory or otherwise objectionable comments/statements.", "Be " +
                "original: feel free to share video content, pictures, links, photographs and text if you have rights to it – if you don’t own it or have permission, don’t post it.", "Be" +
                " mindful of people’s privacy: don’t invade other’s privacy or publicity rights and don’t give out yours or anyone else’s personal information. We respect data privacy as" +
                " set out in our Privacy Policy, which applies to personal information or material shared on this site.", "Keep it true and legal: no unlawful, fraudulent, misleading or " +
                "deceptive posts.", "Be responsible: Children should not post comments without the permission of their parents or guardians.", "Introduce yourself: if you are affiliated " +
                "with our OPTIFAST® VLCD™ brand or Nestlé (employee, agency, incentivised blogger/brand ambassador, etc.), be sure to let everyone know. Your posts should reflect this affiliation.",
                "Do the right thing: ensure all posts comply with this site’s Terms of Use.", "By contributing to this site, you agree to allow Nestlé Health Science to use your content " +
                "(including product ideas and your user ID and photo) without obligation or compensation to you.  Content posted by members on this site will not necessarily reflect our" +
                " views or opinions. We are not responsible for anything contained in links on this site to third party content or websites.  We retain the right to amend these Rules at" +
                " any time.", "Thanks for contributing to the forum! "};
        String[] engagements = termsPage.buildArrayEngagementText();
        System.out.println(engagements);
        org.junit.Assert.assertArrayEquals(expectedEngagements, engagements);
        String pageTitle = termsPage.getCurrentPageTitle();
        String expectedPageTitle = "Terms and Conditions | OPTIFAST VLCD";
        Assert.assertTrue(pageTitle.equals(expectedPageTitle), "Page title doesn't match ! " + "\nExpected: " + expectedPageTitle + "\nActual: " + pageTitle);
        System.out.println("Test passed !");

    }
}
