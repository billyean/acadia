class Palindrome:
    def is_palindrome(self, s):
        half = len(s) // 2
        return s[0:half] == s[:-(half+1):-1]

    def palindromePairs(self, words):
        pairs = []
        for i, iw in enumerate(words):
            for j, jw in enumerate(words):
                if i != j and self.is_palindrome(iw + jw):
                    pairs.append([i, j])

        return pairs

if __name__ == '__main__':
    p = Palindrome()

    print(p.palindromePairs(['bat', 'tab', 'cat']))

    print(p.palindromePairs(['abcd', 'dcba', 'lls', 's', 'sssll']))

    print(p.palindromePairs(["bfdijce","gce","bhgchdcejfcgjfiece","dcebhjhjfgcjdfjg","ejgbjebi","fffgigehhabhfhdge",
                             "fajahcagah","ja","ghedcicbg","ccifjedjig","gihbhhebhheecgeifcii","gdjfajdhgibgdb",
                             "hcjjdi","jhfjecjigjdhbga","dejbejddhje","ecgfijhcja","ghejidhebg","hfehjfhhfjdjeeahjad",
                             "bbajfihihbacdefh","cdeeebaab","cdagiaffffjbjcaia","ab","ejaieca","hcfiecbfcjjhhdj",
                             "aehjicd","ieciciiehidbfaaifcj","dca","cjachjbgbefffci","i","j","ejbggahbhii",
                             "gjdcjfbhefdgd","ecaed","jbbbjffjgib","biiejcgbcahijgbibiaa","aeahieeceggchd","djicdd",
                             "cbj","ggfbeifejd","jgjhehhe","fdgib","ddgabdicbibj","ejbcdfiacicegiibeje","bfdcd",
                             "hhjajfgefgefa","cecgbebfchia","jchdbcbh","jcegc","dejfjjcbcdiadaaaei","bjbhfa","ibjba",
                             "iddhgdjgjgeid","ifiigfijhad","ahihjcfh","degiedaj","fjfhhiddacjdij","ecjhgc",
                             "beebfahffgjaabjafi","fcbdijfjgifjgbijdfc","fc","jgbjajjae","edcgjcigdeecbdhif",
                             "fhbhjcbajfddifci","ch","jahggfgdjidhihcafcji","effbcdfbfjdegacdhgc","acjajjbeaeedjbcfihd",
                             "bag","ffjdidbghbfdeh","eice","h","aeffjeagfigicadg","hgbejbgcecejfeg","hh",
                             "bbadbcbiaechiid","dicajhebdhcgfhgbafa","ehig","eaeddiebehiabf","beijag","gaabbe",
                             "gfiehgehe","hffcdfdhcfiia","efbfhe","fdg","hddeaaeacadbhf","dd","hcaicbbjaechebfj",
                             "aibjjfdhgchjjhhabe","bjgicf","aij","icaajcfdad","f","fgieaifhghgchhcbjad",
                             "gbfjgaabffdeafgejef","bebhbdgjbchbheegba","ceefea","eadjbjfacjeaihefbc",
                             "eghihceecbgiehihe","icadjeefhiead","jjibgdb","efedigddjfdea","c","d","hhcjhbdggcbdif",
                             "ejhga","fejfbccaeac","ehjbeje","dehd","caddigbdaabdffaie","bjjgjiehaffaachfh",
                             "ehhaicejafgddcfihee","jefii","gbijjebhdehi","bfdbcajjfdfh","ca","jbbfibdadiefah",
                             "bbefdfcghcaaiijb","ib","ce","bbfdb","cbbcbjebjbjhcfd","ecjge","gjdegighaagbhjc",
                             "afdcgdggbi","hdgah","gahdgc","jfbgeaebbd","cefbhfcabagjhjhgeabd","jdaacjjdbc",
                             "efacbghiheihedfi","fbffgdcajadjh","aib","ihdcfibgegedeaaa","gehbcj","hjfajbbdc",
                             "ihafhfddfhbfgc","fhecfcjd","adefabbggidhgcjf","dedfejiddhcgabfcbihc","hbibhhghhajg",
                             "iabjgjihiiiebeig","iegajfg","aaj","gfdhaahdbcbfgja","jd","ifeibdfegjcafdiee","dhjih",
                             "afbfdf","gjighgaebb","cbdfjddjfb","aa","gbcajjeajjcfg","gcd","gefddc",
                             "fcbiehbiaddcbgfccbid","ifjbgdc","hhgdebcf","iabe","bihj","ifajbhjjhbcd","diabbjjh",
                             "bgjhihhgba","jfjcfgbchdfhhggcg","ahdbehfhhccfeefcicf","dghf","dacagebbcieggjjbfi",
                             "hejjgdhjbeggedbbgj","a","gghibdbhf","cadfh","fhfbgdegfhccf","hcihffaibjedbjcef",
                             "ghhibbgdhgibbfj","jaegfhahhe","fjacga","cjfacjichhhcbhfhbj","gdaejffeiiigfiaci",
                             "cdfejfjf","ddf","fhfeifgi","ghghiedhejdhicfhgiaj","abajg","daajgijcdh",
                             "bfaiabeaahifjjfdf","ccfhjiegdaj","bhbeegihbifefiia","fb","cjffbhfbgjjfadih",
                             "dhefhfaajejee","deijihhhjjibfea","jbgij","agfdidigfeada","daecfjiaacigcjjcb","bgdiied",
                             "cjadgiie","ghbhfci","jdbfhhhach","ifiegeaad","eajhiechdhjfhdecfjhe","jhbd","gje",
                             "edeggghabeefcaa","aeebiaheefjbigge","bfdhjacgjdficad","fiafgifgajciafiib","aiejhc","gh",
                             "eidfbdfcffci","hbdbbcaghejgchiegjf","cdffefdhbfgh","hbjiahfgiiejfcfbg",
                             "fdfccabdbggbifhjhjga","dhggbecfhdhcbfddafe","ihee","ciaadifia","gd","hac",
                             "dhgaegbichdafdiehe","agdfefdjdbcg","fe","hgdhef","cfgccibbfbcjicg","jj","gdh",
                             "decghhbfdcaaiafecaf","jibccbadhdfabjehfi","gaibdjdgjdifcadce","hdcbeegf","ebdaj",
                             "fgcdh","hgfabihbhibcdccgd","dhehjgicjhhibfghacig","dgfiagb","jhadfjfafagaggfg","eegg",
                             "bjaaeig","chfi","fbb","djcieficibgiiabjdbdc","gdcjijfajgbcb","digh","gbhjcfafhjgchgabjfe",
                             "jhggiggjd","eeccgibhheheaaajfadd","bcdcggagb","gbbdbjgi","jchahjcaahbad","bjefigc",
                             "ggfhee","ejb","ficidccfgffehdi","iadghjbahjeeja","ighibfegabfegfjafab","dfaeejga",
                             "bffbbja","hebbgeigchdb","cfdi","dhha","fjfhfjcabe","gfcca","adeffi","fidgieaijfjcjhgfc",
                             "igibid","jjhechdbabegjabdjfc","ai","dgc","aehhchefa","beihbjaahe","ebiagd","bfcafajjahbid",
                             "baiijjfgjibafacg","hhajgicga","deadad","efcahgh","aiciffj","hhjchdfeiabfjiiie","agihihabbc",
                             "ccacdghah","eifhbbidjbceaegc","hfadbaediajcfbb","jjjjcgeaacffgg","dceiidhcigcbgc","biabjchfi","chgjbhigebba","ciggdgfigbjjjdeccgba","cehe","caidbdi","fjeecdebhidchfeggja","hfbbccad","bbbaggbegaihc","cdahjdjeifccjijdiabj","jcjj","jagf","afagefhgiahebich","fjgejbbdbgab","aih","bgjabhffeafj","fgcghbcheg","ebacdfbchhiaffjgeh","ehhejdbdgg","hafgeiahaffgicafjffi","bbhajadcdeihbggfi","fbdbg","edbiaihc","ed","gcdeefbhidc","gijcigefcecgffjfie","hjg","jahfaghjjbafaebcccf","ahjhafidhbic","gecihhgbhgeeaga","feagfagcef","fhahccbfddhfcaidaa","hajchgjeb","ajhbhfjdfgfdebbgaa","jiedjcgbgifafi","hiaje","cafbaibebabjdadcc","icicefadeecaiceiiaf","jeejjedbfh","ajjdi","diafeaahaeb","heedafafabhcg","hfgdbchbigddjaffg","adahedgichjhhhghg","eajjafcdadbbhfeii","cfachcdbhbcd","fabiigh","gegdbcfghcc","igafadcghfcgbhfccdf","cdbbgbgfggjjedci","ehghd","hgadfefdeeh","ccbeibahfc","jfeag","dihhjehhab","geigahebghifjihdgcfd","fefhbciachhjafj","egdcjbdhgja","fbdfae","cgbdeffbacchjfeig","jgic","caefggbjjdbbjcjfbagb","ddaadegchiejjjbf","ad","dabhgddjgahaach","eddaad","hjbfa","hccejcgcbebfffdhibe","gjababagaaa","ghbjfadjjejaga","cgcdcfadhgdeff","bfihdibecfjehaef","jhijchdaeahdjdfgeac","jb","ejfihbbebihhed","jecgdefeheiebfeabb","aibchhafgcbefdah","dcgefai","fcafbgbfh","gjdaef","eciidjhcbgachbdfjha","dddbccahjdafacjeaib","eifcchejafiijagca","gg","jihahehccafjfdg","dhfia","geghggbdfdgficdhccij","bajjefgdcedjdededd","gdghcgb","bf","gjaeidd","bagc","b","ahaeecafgaafgiif","hfgjbgjicigbciggh","jcfhdgaddbhhgfiebgfi","fejbgcddja","gebjehgdbfhcfidcidhh","ggcaafdbbaiefd","hfaggjab","begicebfhiceicajcfj","iefhaahfajdfchfhecee","icj","cegijjjjfehded","eeadcidaecejchabicbe","ajhhdcachhi","gifibbgaabghj","cajdcfeaefaegdag","bdeedaejj","edjd","ibciabjdefabdgbjgjhi","dhbd","bbijjcjdjjggg","feifjbj","fbdhhahfd","dg","bgeihfafeccibeccjii","gfcecgfebcbgh","jeeefihhaeccf","dgghcbiffdfafjdihai","begae","jbhjbigiceagaigad","acgfbbibihfagih","adgbgjdafcf","gadcjajadeafcabbcg","hfbdfhbcjbdd","hfejjjjbgahcheejef","eihjdcfhbgbcdgdedca","dfg","idfffagdeaee","aejgdiidhbgjaj","cchdbfdaeaaid","igjjaegfe","gedggj","jhbibhehbefddieff","ieaec","ejjifcbdjcjfejcg","djggigibjc","aie"]))
