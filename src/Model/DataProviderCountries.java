package Model;

import Model.Country;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DataProviderCountries{
    private static HttpURLConnection connection;
    private BufferedReader reader;
    private String line;
    private StringBuffer responseContent = new StringBuffer();
    private String largeString;
    private List<String> nameList;
    private List<String> casesListS;
    private List<String> deathsListS;
    private List<String> recoveredListS;
    private static List<Integer> casesList;
    private static List<Integer> deathsList;
    private static List<Integer> recoveredList;
    private static List<Double> latList = new ArrayList<>();
    private static List<Double> longList = new ArrayList<>();
    private static String[] imagesByCountry = new String[211];
    private static List<Country> countryList;
    private static ArrayList<String> allowedNames = new ArrayList<>();

    public static List<Country> getCountryList() {
        return countryList;
    }

    /*Adds a location, image, and name for each country that will be included in the table*/
    public static void addLocationsImagesNames(){
        latList.add(33.93911); longList.add(67.709953);imagesByCountry[0]="af.png";allowedNames.add("Afghanistan");
        latList.add(41.153332); longList.add(20.168331);imagesByCountry[1]="al.png";allowedNames.add("Albania");
        latList.add(28.033886); longList.add(1.659626);imagesByCountry[2]="dz.png";allowedNames.add("Algeria");
        latList.add(42.546245); longList.add(1.601554);imagesByCountry[3]="ad.png";allowedNames.add("Andorra");
        latList.add(-11.202692); longList.add(17.873887);imagesByCountry[4]="ao.png";allowedNames.add("Angola");
        latList.add(18.220554); longList.add(-63.068615);imagesByCountry[5]="ai.png";allowedNames.add("Anguilla");
        latList.add(17.060816); longList.add(-61.796428);imagesByCountry[6]="ag.png";allowedNames.add("Antigua and Barbuda");
        latList.add(-38.416097); longList.add(-63.616672);imagesByCountry[7]="ar.png";allowedNames.add("Argentina");
        latList.add(40.069099); longList.add(45.038189);imagesByCountry[8]="am.png";allowedNames.add("Armenia");
        latList.add(12.52111); longList.add(-69.968338);imagesByCountry[9]="aw.png";allowedNames.add("Aruba");
        latList.add(-25.274398); longList.add(133.775136);imagesByCountry[10]="au.png";allowedNames.add("Australia");
        latList.add(47.516231); longList.add(14.550072);imagesByCountry[11]="at.png";allowedNames.add("Austria");
        latList.add(40.143105); longList.add(47.576927);imagesByCountry[12]="az.png";allowedNames.add("Azerbaijan");
        latList.add(25.03428); longList.add(-77.39628);imagesByCountry[13]="bs.png";allowedNames.add("Bahamas");
        latList.add(25.930414); longList.add(50.637772);imagesByCountry[14]="bh.png";allowedNames.add("Bahrain");
        latList.add(23.684994); longList.add(90.356331);imagesByCountry[15]="bd.png";allowedNames.add("Bangladesh");
        latList.add(13.193887); longList.add(-59.543198);imagesByCountry[16]="bb.png";allowedNames.add("Barbados");
        latList.add(53.709807); longList.add(27.953389);imagesByCountry[17]="by.png";allowedNames.add("Belarus");
        latList.add(50.503887); longList.add(4.469936);imagesByCountry[18]="be.png";allowedNames.add("Belgium");
        latList.add(17.189877); longList.add(-88.49765);imagesByCountry[19]="bz.png";allowedNames.add("Belize");
        latList.add(9.30769); longList.add(2.315834);imagesByCountry[20]="bj.png";allowedNames.add("Benin");
        latList.add(32.321384); longList.add(-64.75737);imagesByCountry[21]="bm.png";allowedNames.add("Bermuda");
        latList.add(27.514162); longList.add(90.433601);imagesByCountry[22]="bt.png";allowedNames.add("Bhutan");
        latList.add(-16.290154); longList.add(-63.588653);imagesByCountry[23]="bo.png";allowedNames.add("Bolivia");
        latList.add(43.915886); longList.add(17.679076);imagesByCountry[24]="ba.png";allowedNames.add("Bosnia and Herzegovina");
        latList.add(-22.328474); longList.add(24.684866);imagesByCountry[25]="bw.png";allowedNames.add("Botswana");
        latList.add(-14.235004); longList.add(-51.92528);imagesByCountry[26]="br.png";allowedNames.add("Brazil");
        latList.add(18.420695); longList.add(-64.639968);imagesByCountry[27]="vg.png";allowedNames.add("British Virgin Islands");
        latList.add(4.535277); longList.add(114.727669);imagesByCountry[28]="bn.png";allowedNames.add("Brunei");
        latList.add(42.733883); longList.add(25.48583);imagesByCountry[29]="bg.png";allowedNames.add("Bulgaria");
        latList.add(12.238333); longList.add(-1.561593);imagesByCountry[30]="bf.png";allowedNames.add("Burkina Faso");
        latList.add(-3.373056); longList.add(29.918886);imagesByCountry[31]="bi.png";allowedNames.add("Burundi");
        latList.add(16.095011); longList.add(-22.807835);imagesByCountry[32]="cv.png";allowedNames.add("Cabo Verde");
        latList.add(12.565679); longList.add(104.990963);imagesByCountry[33]="kh.png";allowedNames.add("Cambodia");
        latList.add(7.369722); longList.add(12.354722);imagesByCountry[34]="cm.png";allowedNames.add("Cameroon");
        latList.add(56.130366); longList.add(-106.346771);imagesByCountry[35]="ca.png";allowedNames.add("Canada");
        latList.add(6.611111); longList.add(20.939444);imagesByCountry[36]="cf.png";allowedNames.add("CAR");
        latList.add(19.513469); longList.add(-80.566956);imagesByCountry[37]="ky.png";allowedNames.add("Cayman Islands");
        latList.add(-35.675147); longList.add(-71.542969);imagesByCountry[38]="cl.png";allowedNames.add("Chile");
        latList.add(35.86166); longList.add(104.195397);imagesByCountry[39]="cn.png";allowedNames.add("China");
        latList.add(4.570868); longList.add(-74.297333);imagesByCountry[40]="co.png";allowedNames.add("Colombia");
        latList.add(-11.875001); longList.add(43.872219);imagesByCountry[41]="km.png";allowedNames.add("Comoros");
        latList.add(-0.228021); longList.add(15.827659);imagesByCountry[42]="cg.png";allowedNames.add("Congo");
        latList.add(9.748917); longList.add(-83.753428);imagesByCountry[43]="cr.png";allowedNames.add("Costa Rica");
        latList.add(45.1); longList.add(15.2);imagesByCountry[44]="hr.png";allowedNames.add("Croatia");
        latList.add(21.521757); longList.add(-77.781167);imagesByCountry[45]="cu.png";allowedNames.add("Cuba");
        latList.add(12.169570); longList.add(-68.990021);imagesByCountry[46]="cw.png";allowedNames.add("Curasao");
        latList.add(35.126413); longList.add(33.429859);imagesByCountry[47]="cy.png";allowedNames.add("Cyprus");
        latList.add(49.817492); longList.add(15.472962);imagesByCountry[48]="cz.png";allowedNames.add("Czechia");
        latList.add(56.26392); longList.add(9.501785);imagesByCountry[49]="dk.png";allowedNames.add("Denmark");
        latList.add(11.825138); longList.add(42.590275);imagesByCountry[50]="dj.png";allowedNames.add("Djibouti");
        latList.add(15.414999); longList.add(-61.370976);imagesByCountry[51]="dm.png";allowedNames.add("Dominica");
        latList.add(18.735693); longList.add(-70.162651);imagesByCountry[52]="do.png";allowedNames.add("Dominican Republic");
        latList.add(-4.038333); longList.add(21.758664);imagesByCountry[53]="cd.png";allowedNames.add("DRC");
        latList.add(-1.831239); longList.add(-78.183406);imagesByCountry[54]="ec.png";allowedNames.add("Ecuador");
        latList.add(26.820553); longList.add(30.802498);imagesByCountry[55]="eg.png";allowedNames.add("Egypt");
        latList.add(13.794185); longList.add(-88.89653);imagesByCountry[56]="ni.png";allowedNames.add("El Salvador");
        latList.add(16.995971); longList.add(-62.067641);imagesByCountry[57]="gq.png";allowedNames.add("Equatorial Guinea");
        latList.add(15.179384); longList.add(39.782334);imagesByCountry[58]="er.png";allowedNames.add("Eritrea");
        latList.add(58.595272); longList.add(25.013607);imagesByCountry[59]="ee.png";allowedNames.add("Estonia");
        latList.add(-26.522503); longList.add(31.465866);imagesByCountry[60]="sz.png";allowedNames.add("Eswatini");
        latList.add(9.145); longList.add(40.489673);imagesByCountry[61]="et.png";allowedNames.add("Ethiopia");
        latList.add(61.505070); longList.add(-6.769180);imagesByCountry[62]="fo.png";allowedNames.add("Faeroe Islands");
        latList.add(-165.618042); longList.add(-59.523613);imagesByCountry[63]="fk.png";allowedNames.add("Falkland Islands");
        latList.add(-16.578193); longList.add(179.414413);imagesByCountry[64]="fj.png";allowedNames.add("Fiji");
        latList.add(61.92411); longList.add(25.748151);imagesByCountry[65]="fi.png";allowedNames.add("Finland");
        latList.add(46.227638); longList.add(2.213749);imagesByCountry[66]="fr.png";allowedNames.add("France");
        latList.add(3.933889); longList.add(-53.125782);imagesByCountry[67]="gf.png";allowedNames.add("French Guiana");
        latList.add(-17.679742); longList.add(-149.406843);imagesByCountry[68]="pf.png";allowedNames.add("French Polynesia");
        latList.add(-0.803689); longList.add(11.609444);imagesByCountry[69]="ga.png";allowedNames.add("Gabon");
        latList.add(13.443182); longList.add(-15.310139);imagesByCountry[70]="gm.png";allowedNames.add("Gambia");
        latList.add(42.315407); longList.add(43.356892);imagesByCountry[71]="ge.png";allowedNames.add("Georgia");
        latList.add(51.165691); longList.add(10.451526);imagesByCountry[72]="de.png";allowedNames.add("Germany");
        latList.add(7.946527); longList.add(-1.023194);imagesByCountry[73]="gh.png";allowedNames.add("Ghana");
        latList.add(36.137741); longList.add(-5.345374);imagesByCountry[74]="gi.png";allowedNames.add("Gibraltar");
        latList.add(39.074208); longList.add(21.824312);imagesByCountry[75]="gr.png";allowedNames.add("Greece");
        latList.add(71.706936 ); longList.add(-42.604303);imagesByCountry[76]="gl.png";allowedNames.add("Greenland");
        latList.add(12.262776); longList.add(-61.604171);imagesByCountry[77]="gd.png";allowedNames.add("Grenada");
        latList.add(16.270000); longList.add(-61.580002);imagesByCountry[78]="gp.png";allowedNames.add("Guadeloupe");
        latList.add(15.783471); longList.add(-90.230759);imagesByCountry[79]="gt.png";allowedNames.add("Guatemala");
        latList.add(9.945587); longList.add(-9.696645);imagesByCountry[80]="gn.png";allowedNames.add("Guinea");
        latList.add(11.803749); longList.add(-15.180413);imagesByCountry[81]="gw.png";allowedNames.add("Guinea-Bissau");
        latList.add(4.860416); longList.add(-58.93018);imagesByCountry[82]="gy.png";allowedNames.add("Guyana");
        latList.add(18.971187); longList.add(-72.285215);imagesByCountry[83]="ht.png";allowedNames.add("Haiti");
        latList.add(15.199999); longList.add(-86.241905);imagesByCountry[84]="hn.png";allowedNames.add("Honduras");
        latList.add(22.396428); longList.add(114.109497);imagesByCountry[85]="hk.png";allowedNames.add("Hong Kong");
        latList.add(47.162494); longList.add(19.503304);imagesByCountry[86]="hu.png";allowedNames.add("Hungary");
        latList.add(64.963051); longList.add(-19.020835);imagesByCountry[87]="is.png";allowedNames.add("Iceland");
        latList.add(20.593684); longList.add(78.96288);imagesByCountry[88]="in.png";allowedNames.add("India");
        latList.add(-0.789275); longList.add(113.921327);imagesByCountry[89]="id.png";allowedNames.add("Indonesia");
        latList.add(32.427908); longList.add(53.688046);imagesByCountry[90]="ir.png";allowedNames.add("Iran");
        latList.add(33.223191); longList.add(43.679291);imagesByCountry[91]="iq.png";allowedNames.add("Iraq");
        latList.add(53.41291); longList.add(-8.24389);imagesByCountry[92]="ie.png";allowedNames.add("Ireland");
        latList.add(54.085117); longList.add(-4.635865);imagesByCountry[93]="im.png";allowedNames.add("Isle of Man");
        latList.add(31.046051); longList.add(34.851612);imagesByCountry[94]="il.png";allowedNames.add("Israel");
        latList.add(41.87194); longList.add(12.56738);imagesByCountry[95]="it.png";allowedNames.add("Italy");
        latList.add(18.109581); longList.add(-77.297508);imagesByCountry[96]="jm.png";allowedNames.add("Jamaica");
        latList.add(36.204824); longList.add(138.252924);imagesByCountry[97]="jp.png";allowedNames.add("Japan");
        latList.add(30.585164); longList.add(36.238414);imagesByCountry[98]="jo.png";allowedNames.add("Jordan");
        latList.add(48.019573); longList.add(66.923684);imagesByCountry[99]="kz.png";allowedNames.add("Kazakhstan");
        latList.add(	-0.023559); longList.add(37.906193);imagesByCountry[100]="ke.png";allowedNames.add("Kenya");
        latList.add(29.31166); longList.add(47.481766);imagesByCountry[101]="kw.png";allowedNames.add("Kuwait");
        latList.add(41.20438); longList.add(74.766098);imagesByCountry[102]="kg.png";allowedNames.add("Kyrgyzstan");
        latList.add(19.85627); longList.add(102.495496);imagesByCountry[103]="la.png";allowedNames.add("Laos");
        latList.add(56.879635); longList.add(24.603189);imagesByCountry[104]="lv.png";allowedNames.add("Latvia");
        latList.add(33.854721); longList.add(35.862285);imagesByCountry[105]="lb.png";allowedNames.add("Lebanon");
        latList.add(-29.609988); longList.add(28.233608);imagesByCountry[106]="ls.png";allowedNames.add("Lesotho");
        latList.add(6.428055); longList.add(-9.429499);imagesByCountry[107]="lr.png";allowedNames.add("Liberia");
        latList.add(26.3351); longList.add(17.228331);imagesByCountry[108]="ly.png";allowedNames.add("Libya");
        latList.add(47.166); longList.add(9.555373);imagesByCountry[109]="li.png";allowedNames.add("Liechtenstein");
        latList.add(55.169438); longList.add(23.881275);imagesByCountry[110]="lt.png";allowedNames.add("Lithuania");
        latList.add(49.815273); longList.add(6.129583);imagesByCountry[111]="lu.png";allowedNames.add("Luxembourg");
        latList.add(22.198745); longList.add(113.543873);imagesByCountry[112]="mo.png";allowedNames.add("Macao");
        latList.add(-18.766947); longList.add(46.869107);imagesByCountry[113]="mg.png";allowedNames.add("Madagascar");
        latList.add(-13.254308); longList.add(34.301525);imagesByCountry[114]="mw.png";allowedNames.add("Malawi");
        latList.add(4.210484); longList.add(101.975766);imagesByCountry[115]="my.png";allowedNames.add("Malaysia");
        latList.add(3.202778); longList.add(73.22068);imagesByCountry[116]="mv.png";allowedNames.add("Maldives");
        latList.add(17.570692); longList.add(-3.996166);imagesByCountry[117]="ml.png";allowedNames.add("Mali");
        latList.add(35.937496); longList.add(14.375416);imagesByCountry[118]="mt.png";allowedNames.add("Malta");
        latList.add(14.641528); longList.add(-61.024174);imagesByCountry[119]="mq.png";allowedNames.add("Martinique");
        latList.add(21.00789); longList.add(-10.940835);imagesByCountry[120]="mr.png";allowedNames.add("Mauritania");
        latList.add(-20.348404); longList.add(57.552152);imagesByCountry[121]="mu.png";allowedNames.add("Mauritius");
        latList.add(23.634501); longList.add(-102.552784);imagesByCountry[122]="mx.png";allowedNames.add("Mexico");
        latList.add(6.84687); longList.add(158.21547);imagesByCountry[123]="fm.png";allowedNames.add("Micronesia");
        latList.add(47.411631); longList.add(28.369885);imagesByCountry[124]="md.png";allowedNames.add("Moldova");
        latList.add(43.750298); longList.add(7.412841);imagesByCountry[125]="mc.png";allowedNames.add("Monaco");
        latList.add(46.862496); longList.add(103.846656);imagesByCountry[126]="mn.png";allowedNames.add("Mongolia");
        latList.add(42.708678); longList.add(19.37439);imagesByCountry[127]="me.png";allowedNames.add("Montenegro");
        latList.add(16.742498); longList.add(-62.187366);imagesByCountry[128]="ms.png";allowedNames.add("Montserrat");
        latList.add(31.791702); longList.add(-7.09262);imagesByCountry[129]="ma.png";allowedNames.add("Morocco");
        latList.add(-18.665695); longList.add(35.529562);imagesByCountry[130]="mz.png";allowedNames.add("Mozambique");
        latList.add(21.913965); longList.add(95.956223);imagesByCountry[131]="mm.png";allowedNames.add("Myanmar");
        latList.add(-22.95764); longList.add(18.49041);imagesByCountry[132]="na.png";allowedNames.add("Namibia");
        latList.add(28.394857); longList.add(84.124008);imagesByCountry[133]="np.png";allowedNames.add("Nepal");
        latList.add(52.132633); longList.add(5.291266);imagesByCountry[134]="nl.png";allowedNames.add("Netherlands");
        latList.add(-20.904305); longList.add(165.618042);imagesByCountry[135]="nc.png";allowedNames.add("New Caledonia");
        latList.add(-40.900557); longList.add(174.885971);imagesByCountry[136]="nz.png";allowedNames.add("New Zealand");
        latList.add(12.865416); longList.add(-85.207229);imagesByCountry[137]="ni.png";allowedNames.add("Nicaragua");
        latList.add(17.607789); longList.add(8.081666);imagesByCountry[138]="ne.png";allowedNames.add("Niger");
        latList.add(9.081999); longList.add(8.675277);imagesByCountry[139]="ng.png";allowedNames.add("Nigeria");
        latList.add(41.608635); longList.add(21.745275);imagesByCountry[140]="mk.png";allowedNames.add("North Macedonia");
        latList.add(60.472024); longList.add(8.468946);imagesByCountry[141]="no.png";allowedNames.add("Norway");
        latList.add(21.512583); longList.add(55.923255);imagesByCountry[142]="pm.png";allowedNames.add("Oman");
        latList.add(30.375321); longList.add(69.345116);imagesByCountry[143]="pk.png";allowedNames.add("Pakistan");
        latList.add(31.952162); longList.add(35.233154);imagesByCountry[144]="ps.png";allowedNames.add("Palestine");
        latList.add(8.5379817942); longList.add(-80.782127);imagesByCountry[145]="pa.png";allowedNames.add("Panama");
        latList.add(-6.314993); longList.add(143.95555);imagesByCountry[146]="pg.png";allowedNames.add("Papua New Guinea");
        latList.add(-23.442503); longList.add(-58.443832);imagesByCountry[147]="py.png";allowedNames.add("Paraguay");
        latList.add(-9.189967); longList.add(-75.015152);imagesByCountry[148]="pe.png";allowedNames.add("Peru");
        latList.add(12.879721); longList.add(121.774017);imagesByCountry[149]="ph.png";allowedNames.add("Philippines");
        latList.add(51.919438); longList.add(19.145136);imagesByCountry[150]="pl.png";allowedNames.add("Poland");
        latList.add(39.399872); longList.add(-8.224454);imagesByCountry[151]="pt.png";allowedNames.add("Portugal");
        latList.add(25.354826); longList.add(51.183884);imagesByCountry[152]="qa.png";allowedNames.add("Qatar");
        latList.add(45.943161); longList.add(24.96676);imagesByCountry[153]="ro.png";allowedNames.add("Romania");
        latList.add(61.52401); longList.add(105.318756);imagesByCountry[154]="ru.png";allowedNames.add("Russia");
        latList.add(-1.940278); longList.add(29.873888);imagesByCountry[155]="rw.png";allowedNames.add("Rwanda");
        latList.add(-21.115141); longList.add(55.536384);imagesByCountry[156]="re.png";allowedNames.add("Raunion");
        latList.add(35.907757); longList.add(127.766922);imagesByCountry[157]="kr.png";allowedNames.add("S.Korea");
        latList.add(17.357822); longList.add(-62.782998);imagesByCountry[158]="kn.png";allowedNames.add("Saint Kitts and Nevis");
        latList.add(18.075277); longList.add(-63.060001);imagesByCountry[159]="sx.png";allowedNames.add("Saint Martin");
        latList.add(46.941936); longList.add(-56.27111);imagesByCountry[160]="pm.png";allowedNames.add("Saint Pierre Miquelon");
        latList.add(-13.759029); longList.add(-172.104629);imagesByCountry[161]="ws.png";allowedNames.add("Samoa");
        latList.add(43.94236); longList.add(12.457777);imagesByCountry[162]="sm.png";allowedNames.add("San Marino");
        latList.add(0.18636); longList.add(6.613081);imagesByCountry[163]="st.png";allowedNames.add("Sao Tome nad Principe");
        latList.add(23.885942); longList.add(45.079162);imagesByCountry[164]="sa.png";allowedNames.add("Saudi Arabia");
        latList.add(14.497401); longList.add(-14.452362);imagesByCountry[165]="sn.png";allowedNames.add("Senegal");
        latList.add(44.016521); longList.add(21.005859);imagesByCountry[166]="rs.png";allowedNames.add("Serbia");
        latList.add(-4.679574); longList.add(55.491977);imagesByCountry[167]="sc.png";allowedNames.add("Seychelles");
        latList.add(8.460555); longList.add(-11.779889);imagesByCountry[168]="sl.png";allowedNames.add("Sierra Leone");
        latList.add(1.352083); longList.add(103.819836);imagesByCountry[169]="sg.png";allowedNames.add("Singapore");
        latList.add(18.035277); longList.add(-63.060001);imagesByCountry[170]="uz.png";allowedNames.add("Sint Maarten");
        latList.add(48.669026); longList.add(19.699024);imagesByCountry[171]="sk.png";allowedNames.add("Slovakia");
        latList.add(46.151241); longList.add(14.995463);imagesByCountry[172]="si.png";allowedNames.add("Slovenia");
        latList.add(-9.64571); longList.add(160.156194);imagesByCountry[173]="sb.png";allowedNames.add("Solomon Islands");
        latList.add(5.152149); longList.add(46.199616);imagesByCountry[174]="so.png";allowedNames.add("Somalia");
        latList.add(-30.559482); longList.add(22.937506);imagesByCountry[175]="za.png";allowedNames.add("S. Africa");
        latList.add(6.876991 ); longList.add(31.306978);imagesByCountry[176]="ss.png";allowedNames.add("South Sudan");
        latList.add(40.463667); longList.add(-3.74922);imagesByCountry[177]="es.png";allowedNames.add("Spain");
        latList.add(7.873054); longList.add(80.771797);imagesByCountry[178]="lk.png";allowedNames.add("Sri Lanka");
        latList.add(12.984305); longList.add(-61.287228);imagesByCountry[179]="vc.png";allowedNames.add("St. Vincent and the Grenadines");
        latList.add(12.862807); longList.add(30.217636);imagesByCountry[180]="sd.png";allowedNames.add("Sudan");
        latList.add(3.919305); longList.add(-56.027783);imagesByCountry[181]="sr.png";allowedNames.add("Suriname");
        latList.add(60.128161); longList.add(18.643501);imagesByCountry[182]="se.png";allowedNames.add("Sweden");
        latList.add(46.818188); longList.add(8.227512);imagesByCountry[183]="ch.png";allowedNames.add("Switzerland");
        latList.add(34.802075); longList.add(38.996815);imagesByCountry[184]="sy.png";allowedNames.add("Syria");
        latList.add(23.69781); longList.add(120.960515);imagesByCountry[185]="tw.png";allowedNames.add("Taiwan");
        latList.add(38.861034); longList.add(71.276093);imagesByCountry[186]="tj.png";allowedNames.add("Tajikistan");
        latList.add(-6.369028); longList.add(34.888822);imagesByCountry[187]="tz.png";allowedNames.add("Tanzania");
        latList.add(15.870032); longList.add(100.992541);imagesByCountry[188]="th.png";allowedNames.add("Thailand");
        latList.add(-8.874217); longList.add(125.727539);imagesByCountry[189]="tl.png";allowedNames.add("Timor-Leste");
        latList.add(8.619543); longList.add(0.824782);imagesByCountry[190]="tg.png";allowedNames.add("Togo");
        latList.add(10.691803); longList.add(-61.222503);imagesByCountry[191]="tt.png";allowedNames.add("Trinidad and Tobago");
        latList.add(33.886917); longList.add(9.537499);imagesByCountry[192]="tn.png";allowedNames.add("Tunisia");
        latList.add(38.963745); longList.add(35.243322);imagesByCountry[193]="tr.png";allowedNames.add("Turkey");
        latList.add(23.424076); longList.add(53.847818);imagesByCountry[194]="ae.png";allowedNames.add("UAE");
        latList.add(1.373333); longList.add(32.290275);imagesByCountry[195]="ug.png";allowedNames.add("Uganda");
        latList.add(55.378051); longList.add(-3.435973);imagesByCountry[196]="gb.png";allowedNames.add("Uk");
        latList.add(48.379433); longList.add(31.16558);imagesByCountry[197]="ua.png";allowedNames.add("Ukraine");
        latList.add(-32.522779); longList.add(-55.765835);imagesByCountry[198]="uy.png";allowedNames.add("Uruguay");
        latList.add(37.09024); longList.add(-95.712891);imagesByCountry[199]="us.png";allowedNames.add("USA");
        latList.add(41.759373); longList.add(64.628059);imagesByCountry[200]="uz.png";allowedNames.add("Uzbekistan");
        latList.add(-15.376706); longList.add(166.959158);imagesByCountry[201]="vu.png";allowedNames.add("Vanuatu");
        latList.add(41.902916); longList.add(12.453389);imagesByCountry[202]="va.png";allowedNames.add("Vatican City");
        latList.add(6.42375); longList.add(-66.58973);imagesByCountry[203]="ve.png";allowedNames.add("Venezuela");
        latList.add(14.058324); longList.add(108.277199);imagesByCountry[204]="vn.png";allowedNames.add("Vietnam");
        latList.add(-14.3013 ); longList.add(-178.0909);imagesByCountry[205]="wf.png";allowedNames.add("Wallis and Futuna");
        latList.add(24.215527); longList.add(-12.885834);imagesByCountry[206]="eh.png";allowedNames.add("Western Sahara");
        latList.add(0.0);longList.add(0.0);imagesByCountry[207]="worldMapFlag.png";allowedNames.add("World");
        latList.add(15.369445);longList.add(44.191006);imagesByCountry[208]="ye.png";allowedNames.add("Yemen");
        latList.add(-15.416667); longList.add( 28.283333);imagesByCountry[209]="zm.png";allowedNames.add("Zambia");
        latList.add(-19.015438);longList.add(29.154857);imagesByCountry[210]="zw.png";allowedNames.add("Zimbabwe");
        }

     /*On instantiation, Adds all the attributes for each country from the data online in the API (https://coronavirus-19-api.herokuapp.com/countries)*/
    public DataProviderCountries() throws IOException {
        countryList = new ArrayList<>();
        initializeLists();
        getAllData();
        addDataToLists();
        convertListsToInteger();
        addLocationsImagesNames();
        sortAlphabetically();
        addAllToCountryList();
    }
    /*Initializes all lists that will be used to store the data from each country in order*/
    private void initializeLists(){
        casesListS = new ArrayList<>();
        deathsListS = new ArrayList<>();
        recoveredListS = new ArrayList<>();
        nameList = new ArrayList<>();
        casesList = new ArrayList<>();
        deathsList = new ArrayList<>();
        recoveredList = new ArrayList<>();
    }
    /*Gets all the data provided by the API (https://coronavirus-19-api.herokuapp.com/countries)
     *and stores it in a String
     */
    private void getAllData(){
        try {
            URL url = new URL("https://coronavirus-19-api.herokuapp.com/countries");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();

            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);

                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
            }
            largeString = responseContent.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*Adds the data from the largeString to the lists*/
    private void addDataToLists(){
        while(largeString.length()>0 && largeString.indexOf("country\":\"")!=-1) {
            getName();
            getCases();
            getDeaths();
            getRecoveries();
        }
    }

    /*Gets the name of the current country in the String largeString
     *(which stores all the data) adds it to the nameList in the
     * corresponding order and then changes the largeString starting
     * from the end of the current name
     */
    public String getName(){
        int nameStartInd = largeString.indexOf("country\":\"");
        int nameEndInd = largeString.indexOf("\",\"");
        String name = largeString.substring(nameStartInd + 10, nameEndInd);
        largeString = largeString.substring(nameEndInd + 1);
        nameList.add(name);
        return name;
    }
    /*Gets the deaths of the current country in the String largeString
     *(which stores all the data) adds it to the nameList in the
     * corresponding order and then changes the largeString starting
     * from the end of the current name
     */
    private void getDeaths(){
        int deathStartInd = largeString.indexOf("\"deaths\":");
        int deathEndInd = largeString.indexOf(",\"todayDeaths");
        String death = largeString.substring(deathStartInd + 9, deathEndInd);
        largeString = largeString.substring(deathEndInd + 1);
        if(!death.equals("null")) {
            deathsListS.add(death);
        }
        else{
            casesListS.add("0");
        }
    }
    /*Gets the cases of the current country in the String largeString
     *(which stores all the data) adds it to the nameList in the
     * corresponding order and then changes the largeString starting
     * from the end of the current name
     */
    private void getCases(){
        int casesStartInd = largeString.indexOf("\"cases\":");
        int casesEndInd = largeString.indexOf(",\"todayCases");
        String cases = largeString.substring(casesStartInd + 8, casesEndInd);
        largeString = largeString.substring(casesEndInd + 1);
        if(!cases.equals("null")) {
            casesListS.add(cases);
        }
        else{
            casesListS.add("0");
        }
    }
    /*Gets the recoveries of the current country in the String largeString
     *(which stores all the data) adds it to the nameList in the
     * corresponding order and then changes the largeString starting
     * from the end of the current name
     */
    private void getRecoveries(){
        int recoveredStartInd = largeString.indexOf("\"recovered\":");
        int recoveredEndInd = largeString.indexOf(",\"active");
        String recovered = largeString.substring(recoveredStartInd + 12, recoveredEndInd);
        largeString = largeString.substring(recoveredEndInd + 1);
        if(!recovered.equals("null")) {
            recoveredListS.add(recovered);
        }
        else{
            recoveredListS.add("0");
        }
    }
    /*Changes any abbreviation in the name of a country its full name*/
    private void changeSmallNamesToComplete(Country country){
        if (country.getName().equals("USA")) {
            country.setName("United States");
        } else if (country.getName().equals("DRC")) {
            country.setName("Democratic Republic of the Congo");
        } else if (country.getName().equals("CAR")) {
            country.setName("Central African Republic");
        } else if (country.getName().equals("UK")) {
            country.setName("United Kingdom");
        } else if (country.getName().equals("S. Korea")) {
            country.setName("South Korea");
        } else if (country.getName().equals("UAE")) {
            country.setName("United Arab Emirates");
        }
        else if (country.getName().equals("Congo")) {
            country.setName("Republic of Congo");
        }
        else if (country.getName().equals("World")) {
            country.setName("Worldwide");
        }
        for(int i=0;i<nameList.size();i++){
            if (nameList.get(i).equals("USA")) {
                nameList.set(i,"United States");
            } else if (nameList.get(i).equals("DRC")) {
                nameList.set(i,"Democratic Republic of the Congo");
            } else if (nameList.get(i).equals("CAR")) {
                nameList.set(i,"Central African Republic");
            } else if (nameList.get(i).equals("UK")) {
                nameList.set(i,"United Kingdom");
            } else if (nameList.get(i).equals("S. Korea")) {
                nameList.set(i,"South Korea");
            } else if (nameList.get(i).equals("UAE")) {
                nameList.set(i,"United Arab Emirates");
            }
            else if (country.getName().equals("Congo")) {
                country.setName("Republic of Congo");
            }
            else if (nameList.get(i).equals("World")) {
                nameList.set(i,"Worldwide");
            }
        }

    }
    /*Sorts all the lists in alphabetical order according to the names of the countries*/
    private void sortAlphabetically(){
        String temp = "";
        for (int j = 0; j < nameList.size(); j++) {
            for (int i = j + 1; i < nameList.size(); i++) {
                if (nameList.get(i).toLowerCase().compareTo(nameList.get(j).toLowerCase()) < 0) {
                    temp = nameList.get(j);
                    nameList.set(j,nameList.get(i));
                    nameList.set(i,temp);

                    int temp1 = casesList.get(j);
                    casesList.set(j,casesList.get(i));
                    casesList.set(i,temp1);

                    int temp2 = deathsList.get(j);
                    deathsList.set(j,deathsList.get(i));
                    deathsList.set(i,temp2);

                    int temp3 = recoveredList.get(j);
                    recoveredList.set(j,recoveredList.get(i));
                    recoveredList.set(i,temp3);
                }
            }
        }
    }
    /*Transfers the deaths, cases and recoveries lists (Strings) to their corresponding lists after being converted to integers*/
    private void convertListsToInteger(){
        for(String number : casesListS) {
            casesList.add(Integer.parseInt(number));
        }
        for(String number : deathsListS) {
            deathsList.add(Integer.parseInt(number));
        }
        for(String number : recoveredListS) {
            recoveredList.add(Integer.parseInt(number));
        }
        removeUnwantedCountries();
    }
    /*Removes any unwanted countries from the lists so they are not added to the countryLists*/
    private void removeUnwantedCountries(){
        for(int i=0;i<nameList.size();i++){
            if(nameList.get(i).equals("Diamond Princess") || nameList.get(i).equals("MS Zaandam")||
                    nameList.get(i).equals("Ivory Coast")|| nameList.get(i).equals("Mayotte")||
                    nameList.get(i).equals("Channel Islands")|| nameList.get(i).equals("Chad")||
                    nameList.get(i).equals("Saint Lucia")|| nameList.get(i).equals("Turks and Caicos") ||
                    nameList.get(i).equals("St. Barth") || nameList.get(i).equals("Caribbean Netherlands") || nameList.get(i).equals("Saint Helena") ||
                    nameList.get(i).equals("Marshall Islands")){
                nameList.remove(i);
                casesList.remove(i);
                deathsList.remove(i);
                recoveredList.remove(i);
                i--;
            }
            if(i==-1){
                i=0;
            }
            int count = 0;
            System.out.println(i);
            for(int j=0;j< allowedNames.size();j++){
                System.out.println(i);
                if(allowedNames.equals(nameList.get(i))){
                    count++;
                }
            }
            if(count==0 && nameList.get(i).indexOf("Cura")!=-1 &&  nameList.get(i).indexOf("union")!=-1){
                nameList.remove(i);
                casesList.remove(i);
                deathsList.remove(i);
                recoveredList.remove(i);
                i--;
            }
        }
    }

    /*Creates all countries with the specified name, cases, deaths, and recoveries and adds them to the countryList*/
    private void addAllToCountryList()  {
        for (int i = 0; i < nameList.size(); i++) {
            Country countryToAdd = new Country(new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/"+imagesByCountry[i]))),nameList.get(i), new Infection(casesList.get(i), deathsList.get(i), recoveredList.get(i)));
            changeSmallNamesToComplete(countryToAdd);
            countryList.add(countryToAdd);
        }
    }
}