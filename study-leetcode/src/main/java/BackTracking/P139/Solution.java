package BackTracking.P139;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private String target;
    private List<String> wordDict;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.target=s;
        this.wordDict=wordDict;
        return backTracking(new StringBuilder(target));
    }
    public boolean backTracking(StringBuilder temp){
        if (temp.length()==0) {
            return true;
        }
        for (int i = 0; i < wordDict.size(); i++) {
            String dic=wordDict.get(i);
            int before=dic.length();
            //判定当前剩余字符串长度
            if (temp.length()>=before) {
                String subString=temp.substring(0,before);
                if (subString.equals(dic)) {
                    temp.delete(0,before);
                    boolean subBoolean=backTracking(temp);
                    if (subBoolean) {
                        return true;
                    }
                    temp.insert(0,subString);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> temp= new ArrayList<>();

        String test= "kfomka,hecagbngambii,anobmnikj,c,nnkmfelneemfgcl,ah,bgomgohl,lcbjbg,ebjfoiddndih,hjknoamjbfhckb,eioldlijmmla,nbekmcnakif,fgahmihodolmhbi,gnjfe,hk,b,jbfgm,ecojceoaejkkoed,cemodhmbcmgl,j,gdcnjj,kolaijoicbc,liibjjcini,lmbenj,eklingemgdjncaa,m,hkh,fblb,fk,nnfkfanaga,eldjml,iejn,gbmjfdooeeko,jafogijka,ngnfggojmhclkjd,bfagnfclg,imkeobcdidiifbm,ogeo,gicjog,cjnibenelm,ogoloc,edciifkaff,kbeeg,nebn,jdd,aeojhclmdn,dilbhl,dkk,bgmck,ohgkefkadonafg,labem,fheoglj,gkcanacfjfhogjc,eglkcddd,lelelihakeh,hhjijfiodfi,enehbibnhfjd,gkm,ggj,ag,hhhjogk,lllicdhihn,goakjjnk,lhbn,fhheedadamlnedh,bin,cl,ggjljjjf,fdcdaobhlhgj,nijlf,i,gaemagobjfc,dg,g,jhlelodgeekj,hcimohlni,fdoiohikhacgb,k,doiaigclm,bdfaoncbhfkdbjd,f,jaikbciac,cjgadmfoodmba,molokllh,gfkngeebnggo,lahd,n,ehfngoc,lejfcee,kofhmoh,cgda,de,kljnicikjeh,edomdbibhif,jehdkgmmofihdi,hifcjkloebel,gcghgbemjege,kobhhefbbb,aaikgaolhllhlm,akg,kmmikgkhnn,dnamfhaf,mjhj,ifadcgmgjaa,acnjehgkflgkd,bjj,maihjn,ojakklhl,ign,jhd,kndkhbebgh,amljjfeahcdlfdg,fnboolobch,gcclgcoaojc,kfokbbkllmcd,fec,dljma,noa,cfjie,fohhemkka,bfaldajf,nbk,kmbnjoalnhki,ccieabbnlhbjmj,nmacelialookal,hdlefnbmgklo,bfbblofk,doohocnadd,klmed,e,hkkcmbljlojkghm,jjiadlgf,ogadjhambjikce,bglghjndlk,gackokkbhj,oofohdogb,leiolllnjj,edekdnibja,gjhglilocif,ccfnfjalchc,gl,ihee,cfgccdmecem,mdmcdgjelhgk,laboglchdhbk,ajmiim,cebhalkngloae,hgohednmkahdi,ddiecjnkmgbbei,ajaengmcdlbk,kgg,ndchkjdn,heklaamafiomea,ehg,imelcifnhkae,hcgadilb,elndjcodnhcc,nkjd,gjnfkogkjeobo,eolega,lm,jddfkfbbbhia,cddmfeckheeo,bfnmaalmjdb,fbcg,ko,mojfj,kk,bbljjnnikdhg,l,calbc,mkekn,ejlhdk,hkebdiebecf,emhelbbda,mlba,ckjmih,odfacclfl,lgfjjbgookmnoe,begnkogf,gakojeblk,bfflcmdko,cfdclljcg,ho,fo,acmi,oemknmffgcio,mlkhk,kfhkndmdojhidg,ckfcibmnikn,dgoecamdliaeeoa,ocealkbbec,kbmmihb,ncikad,hi,nccjbnldneijc,hgiccigeehmdl,dlfmjhmioa,kmff,gfhkd,okiamg,ekdbamm,fc,neg,cfmo,ccgahikbbl,khhoc,elbg,cbghbacjbfm,jkagbmfgemjfg,ijceidhhajmja,imibemhdg,ja,idkfd,ndogdkjjkf,fhic,ooajkki,fdnjhh,ba,jdlnidngkfffbmi,jddjfnnjoidcnm,kghljjikbacd,idllbbn,d,mgkajbnjedeiee,fbllleanknmoomb,lom,kofjmmjm,mcdlbglonin,gcnboanh,fggii,fdkbmic,bbiln,cdjcjhonjgiagkb,kooenbeoongcle,cecnlfbaanckdkj,fejlmog,fanekdneoaammb,maojbcegdamn,bcmanmjdeabdo,amloj,adgoej,jh,fhf,cogdljlgek,o,joeiajlioggj,oncal,lbgg,elainnbffk,hbdi,femcanllndoh,ke,hmib,nagfahhljh,ibifdlfeechcbal,knec,oegfcghlgalcnno,abiefmjldmln,mlfglgni,jkofhjeb,ifjbneblfldjel,nahhcimkjhjgb,cdgkbn,nnklfbeecgedie,gmllmjbodhgllc,hogollongjo,fmoinacebll,fkngbganmh,jgdblmhlmfij,fkkdjknahamcfb,aieakdokibj,hddlcdiailhd,iajhmg,jenocgo,embdib,dghbmljjogka,bahcggjgmlf,fb,jldkcfom,mfi,kdkke,odhbl,jin,kcjmkggcmnami,kofig,bid,ohnohi,fcbojdgoaoa,dj,ifkbmbod,dhdedohlghk,nmkeakohicfdjf,ahbifnnoaldgbj,egldeibiinoac,iehfhjjjmil,bmeimi,ombngooicknel,lfdkngobmik,ifjcjkfnmgjcnmi,fmf,aoeaa,an,ffgddcjblehhggo,hijfdcchdilcl,hacbaamkhblnkk,najefebghcbkjfl,hcnnlogjfmmjcma,njgcogemlnohl,ihejh,ej,ofn,ggcklj,omah,hg,obk,giig,cklna,lihaiollfnem,ionlnlhjckf,cfdlijnmgjoebl,dloehimen,acggkacahfhkdne,iecd,gn,odgbnalk,ahfhcd,dghlag,bchfe,dldblmnbifnmlo,cffhbijal,dbddifnojfibha,mhh,cjjol,fed,bhcnf,ciiibbedklnnk,ikniooicmm,ejf,ammeennkcdgbjco,jmhmd,cek,bjbhcmda,kfjmhbf,chjmmnea,ifccifn,naedmco,iohchafbega,kjejfhbco,anlhhhhg"; Arrays.stream(test.split(",")).forEach(s -> temp.add(s));

        new Solution().wordBreak("fohhemkkaecojceoaejkkoedkofhmohkcjmkggcmnami",temp);

        StringBuilder stringBuilder=new StringBuilder("123");
        stringBuilder.insert(0,"000");
    }
}