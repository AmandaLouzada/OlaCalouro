package louzada.olacalouro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;


/**
 * Created by amanda on 25/02/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {



    private static final String BANCO_DADOS = "OlaCalouro";
    private static int VERSAO = 8;


    public  static  class  Telefone {
        public static final  String TABELA = "telefone";
        public static final  String _ID = "_id";
        public static final  String NOME = "nome";
        public static final  String TELEFONE = "telefone";
        public static final  String DESCRICAO = "descricao";
        public static final  String CATEGORIA = "categoria";

        public static final String[] COLUNAS = new String[]{
                _ID, NOME, TELEFONE, DESCRICAO, CATEGORIA
        };
    }

    public  static  class  Local {
        public static final  String TABELA = "local";
        public static final String _ID = "_id";
        public static final String NOME = "nome";
        public static final String DESCRICAO = "descricao";
        public static final String LATITUDE = "latitude";
        public static final String LONGITUDE = "longitude";
        public static final String TIPO = "tipo";

        public static final String[] COLUNAS = new String[]{
                _ID, NOME, DESCRICAO, LATITUDE, LONGITUDE, TIPO
        };
    }

    public  static  class  Vertice {
        public static final  String TABELA = "vertice";
        public static final String _ID = "_id";
        public static final String NOME = "nome";
        public static final String LATITUDE = "latitude";
        public static final String LONGITUDE = "longitude";
        public static final String ID_LOCAL = "id_local";


        public static final String[] COLUNAS = new String[]{
                _ID, NOME, LATITUDE, LONGITUDE, ID_LOCAL
        };
    }

    public  static  class  Aresta {
        public static final  String TABELA = "aresta";
        public static final String _ID = "_id";
        public static final String ID_VERTICE_ORIGEM = "id_vertice_origem";
        public static final String ID_VERTICE_DESTINO = "id_vertice_destino";
        public static final String PESO = "peso";

        public static final String[] COLUNAS = new String[]{
                _ID, ID_VERTICE_ORIGEM, ID_VERTICE_DESTINO, PESO
        };
    }

    public DatabaseHelper(Context context) {
        super(context, BANCO_DADOS, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE TELEFONE (_id INTEGER PRIMARY KEY," +
                "nome TEXT, telefone TEXT, descricao TEXT, categoria INTEGER);");

        db.execSQL("CREATE TABLE LOCAL (_id INTEGER PRIMARY KEY," +
                "nome TEXT, latitude REAL, longitude REAL, descricao TEXT, tipo INTEGER);");

        db.execSQL("CREATE TABLE VERTICE (_id INTEGER PRIMARY KEY," +
                "nome TEXT, latitude REAL NOT NULL, longitude REAL NOT NULL, id_local INTEGER, FOREIGN KEY(id_local) REFERENCES LOCAL(_id));");


        db.execSQL("CREATE TABLE ARESTA (_id INTEGER NOT NULL," +
                " id_vertice_origem INTEGER," +
                " id_vertice_destino INTEGER," +
                " peso REAL," +
                " PRIMARY KEY(_id));");
        db.execSQL("INSERT INTO VERTICE VALUES (1,'',-10.1821752,-48.3587801,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (2,'',-10.1819218,-48.3590376,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (3,'',-10.1818452,-48.3589357,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (4,'',-10.1814519,-48.3587453,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (5,'',-10.1814704,-48.3592603,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (6,'',-10.1812988,-48.3593112,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (7,'',-10.181114,-48.3593112,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (8,'',-10.1810163,-48.3593461,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (9,'',-10.1806203,-48.359625,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (10,'',-10.1806203,-48.3594427,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (11,'',-10.1810453,-48.3594507,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (12,'',-10.1812671,-48.3594185,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (13,'',-10.1813727,-48.3594614,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (14,'',-10.1808922,-48.3596385,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (15,'',-10.1815654,-48.3593488,10);");
        db.execSQL("INSERT INTO VERTICE VALUES (16,'',-10.1814783,-48.3596116,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (17,'',-10.1815073,-48.3597592,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (18,'',-10.1812829,-48.3601052,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (19,'',-10.1812011,-48.3602527,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (20,'',-10.1808684,-48.3598557,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (21,'',-10.1804672,-48.3597136,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (22,'',-10.1799365,-48.3597109,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (23,'',-10.1798468,-48.3599764,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (24,'',-10.1798573,-48.360258,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (25,'',-10.1798124,-48.3602822,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (26,'',-10.1793504,-48.3606336,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (27,'',-10.1798151,-48.3604056,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (28,'',-10.17972,-48.3604109,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (29,'',-10.1797992,-48.3597028,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (30,'',-10.1801134,-48.3605987,2);");
        db.execSQL("INSERT INTO VERTICE VALUES (31,'',-10.179984,-48.3608374,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (32,'',-10.1800448,-48.3613336,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (33,'',-10.1799867,-48.3614194,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (34,'',-10.1801028,-48.3616313,3);");
        db.execSQL("INSERT INTO VERTICE VALUES (35,'',-10.1797992,-48.3618325,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (36,'',-10.1796646,-48.3617547,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (37,'',-10.1794956,-48.3616635,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (38,'',-10.1792528,-48.3621249,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (39,'',-10.1794772,-48.362259,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (40,'',-10.1798045,-48.362259,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (41,'',-10.1787274,-48.3622563,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (42,'',-10.1788594,-48.3620873,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (43,'',-10.1788647,-48.3619022,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (44,'',-10.1788726,-48.3617064,19);");
        db.execSQL("INSERT INTO VERTICE VALUES (45,'',-10.1792264,-48.3615053,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (46,'',-10.1791023,-48.3614597,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (47,'',-10.1788832,-48.3614597,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (48,'',-10.1786561,-48.3614543,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (49,'',-10.1787723,-48.3615133,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (50,'',-10.1786561,-48.3613363,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (51,'',-10.1786535,-48.3612263,17);");
        db.execSQL("INSERT INTO VERTICE VALUES (52,'',-10.1792237,-48.361221,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (53,'',-10.1792264,-48.3611244,1);");
        db.execSQL("INSERT INTO VERTICE VALUES (54,'',-10.1792264,-48.3609313,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (55,'',-10.1786033,-48.3609447,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (56,'',-10.1791498,-48.360934,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (57,'',-10.1791524,-48.3607516,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (58,'',-10.1792105,-48.3606684,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (59,'',-10.1792422,-48.3607489,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (60,'',-10.1788198,-48.3594292,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (61,'',-10.1795062,-48.3594319,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (62,'',-10.1791524,-48.3594346,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (63,'',-10.1789782,-48.3591557,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (64,'',-10.1793161,-48.3591396,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (65,'',-10.1796699,-48.3591557,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (66,'',-10.1793214,-48.358984,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (67,'',-10.1793161,-48.3592924,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (68,'',-10.1791577,-48.3592924,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (69,'',-10.1789756,-48.3592978,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (70,'',-10.1789729,-48.3589733,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (71,'',-10.1796831,-48.3589974,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (72,'',-10.1796778,-48.3593032,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (73,'',-10.1786852,-48.3594373,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (74,'',-10.1786931,-48.3590162,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (75,'',-10.1795036,-48.3579835,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (76,'',-10.1795036,-48.3581418,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (77,'',-10.1796461,-48.358123,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (78,'',-10.1796567,-48.3584502,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (79,'',-10.1794534,-48.3584529,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (80,'',-10.1794455,-48.3585253,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (81,'',-10.1792475,-48.3585495,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (82,'',-10.1791023,-48.3585602,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (83,'',-10.1791076,-48.358638,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (84,'',-10.1789861,-48.3585763,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (85,'',-10.1789861,-48.3584154,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (86,'',-10.1792237,-48.3583832,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (87,'',-10.1793108,-48.3583805,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (88,'',-10.1792052,-48.3583081,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (89,'',-10.1789518,-48.3583322,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (90,'',-10.1788964,-48.3581069,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (91,'',-10.1788647,-48.3584207,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (92,'',-10.1783816,-48.358579,20);");
        db.execSQL("INSERT INTO VERTICE VALUES (93,'',-10.1783736,-48.3581874,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (94,'',-10.1784238,-48.358115,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (95,'',-10.1781862,-48.3584824,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (96,'',-10.1783076,-48.3583,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (97,'',-10.1780832,-48.3581954,21);");
        db.execSQL("INSERT INTO VERTICE VALUES (98,'',-10.1779196,-48.3584905,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (99,'',-10.1779143,-48.3585763,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (100,'',-10.1778034,-48.3586648,18);");
        db.execSQL("INSERT INTO VERTICE VALUES (101,'',-10.1779064,-48.358748,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (102,'',-10.1781044,-48.3587506,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (103,'',-10.1782707,-48.3587453,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (104,'',-10.1783024,-48.358705,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (105,'',-10.1783024,-48.3585763,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (106,'',-10.177674,-48.3587506,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (107,'',-10.177674,-48.3588472,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (108,'',-10.1780964,-48.3588526,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (109,'',-10.1783789,-48.3588499,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (110,'',-10.177674,-48.3591262,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (111,'',-10.1778192,-48.3593059,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (112,'',-10.177674,-48.3593032,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (113,'',-10.178012,-48.3594695,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (114,'',-10.1779354,-48.3593032,16);");
        db.execSQL("INSERT INTO VERTICE VALUES (115,'',-10.177674,-48.3594587,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (116,'',-10.1779935,-48.3591315,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (117,'',-10.1781044,-48.3591315,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (118,'',-10.1783182,-48.3591315,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (119,'',-10.1783129,-48.3595097,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (120,'',-10.1782179,-48.3596438,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (121,'',-10.1781044,-48.3596465,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (122,'',-10.1776714,-48.3596465,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (123,'',-10.1771988,-48.358756,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (124,'',-10.1767976,-48.3601829,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (125,'',-10.1772147,-48.3586568,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (126,'',-10.1771196,-48.3586541,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (127,'',-10.1771117,-48.3585522,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (128,'',-10.1768028,-48.3585575,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (129,'',-10.1764728,-48.3586058,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (130,'',-10.1764676,-48.3588445,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (131,'',-10.177117,-48.3582008,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (132,'',-10.1768134,-48.3581311,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (133,'',-10.1771223,-48.3588499,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (134,'',-10.1771962,-48.3588445,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (135,'',-10.178268,-48.3581847,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (136,'',-10.1783103,-48.3582062,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (137,'',-10.1771909,-48.359035,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (138,'',-10.177674,-48.3590215,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (139,'',-10.1778219,-48.3591262,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (140,'',-10.1771777,-48.3596411,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (141,'',-10.177183,-48.3593434,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (142,'',-10.177183,-48.3597001,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (143,'',-10.1772728,-48.359912,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (144,'',-10.177674,-48.359912,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (145,'',-10.1768002,-48.3599067,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (146,'',-10.1772701,-48.3601964,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (147,'',-10.1771381,-48.3602017,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (148,'',-10.1769137,-48.3601776,28);");
        db.execSQL("INSERT INTO VERTICE VALUES (149,'',-10.1773625,-48.3601964,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (150,'',-10.1772675,-48.3604431,9);");
        db.execSQL("INSERT INTO VERTICE VALUES (151,'',-10.1767949,-48.3604431,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (152,'',-10.1773625,-48.3604512,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (153,'',-10.177674,-48.3604512,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (154,'',-10.1781123,-48.3599147,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (155,'',-10.1779961,-48.3600596,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (156,'',-10.178004,-48.3604458,15);");
        db.execSQL("INSERT INTO VERTICE VALUES (157,'',-10.1781149,-48.3604538,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (158,'',-10.1777374,-48.3604538,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (159,'',-10.1781044,-48.3597109,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (160,'',-10.177674,-48.3597082,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (161,'',-10.1777374,-48.3606926,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (162,'',-10.1773678,-48.3606952,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (163,'',-10.1773493,-48.3608535,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (164,'',-10.1776054,-48.3608454,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (165,'',-10.1779908,-48.3607006,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (166,'',-10.1781176,-48.3606926,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (167,'',-10.1784212,-48.3606979,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (168,'',-10.1784185,-48.3605719,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (169,'',-10.1784291,-48.3598208,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (170,'',-10.1782971,-48.3597136,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (171,'',-10.1783895,-48.3595258,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (172,'',-10.1785136,-48.3596921,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (173,'',-10.1783842,-48.3594319,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (174,'',-10.1786033,-48.3605719,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (175,'',-10.1760214,-48.3596894,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (176,'',-10.1760848,-48.3588392,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (177,'',-10.1760214,-48.3588794,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (178,'',-10.176032,-48.3606926,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (179,'',-10.1764702,-48.3606926,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (180,'',-10.1769296,-48.3607006,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (181,'',-10.1769296,-48.3610708,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (182,'',-10.1764781,-48.3610949,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (183,'',-10.1772886,-48.3613282,'');");
        db.execSQL("INSERT INTO VERTICE VALUES (184,'',-10.1763197,-48.3611003,27);");
        db.execSQL("INSERT INTO VERTICE VALUES (185,'',-10.1765758,-48.3610949,26);");
        db.execSQL("INSERT INTO VERTICE VALUES (186,'',-10.1760293,-48.3614007,'');");
        db.execSQL("INSERT INTO ARESTA VALUES (1,1,2,40.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (2,2,3,15.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (3,3,4,50.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (4,2,15,53.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (5,3,5,56.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (6,5,6,20.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (7,6,7,22.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (8,7,8,12.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (9,9,10,20.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (10,10,161,25.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (11,11,14,28.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (12,12,11,24.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (13,13,12,12.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (14,13,15,25.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (15,2,1,40.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (16,3,2,15.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (17,4,3,50.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (18,15,2,53.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (19,5,3,56.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (20,6,5,20.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (21,7,6,22.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (22,8,7,12.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (23,10,9,20.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (24,161,10,25.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (25,14,11,28.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (26,11,12,24.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (27,12,13,12.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (28,15,13,25.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (29,14,21,49.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (30,15,16,31.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (31,16,15,31.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (32,16,17,17.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (33,17,18,45.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (34,18,19,18.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (35,19,249,185.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (36,20,21,47.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (37,20,19,58.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (38,21,22,59.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (39,22,23,31.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (40,22,29,15.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (41,23,24,31.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (42,24,25,6.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (43,25,28,18.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (44,25,27,14.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (45,26,58,16.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (46,27,59,74.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (47,28,26,48.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (48,29,172,144.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (49,30,27,40.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (50,30,31,30.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (51,31,32,55.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (52,32,33,12.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (53,33,34,26.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (54,34,35,40.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (55,35,36,17.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (56,35,40,47.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (57,36,37,21.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (58,36,39,59.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (59,37,45,35.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (60,37,38,57.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (61,37,36,21.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (62,38,43,50.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (63,38,39,28.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (64,38,37,57.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (65,39,41,83.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (66,39,40,36.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (67,40,39,36.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (68,40,35,47.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (69,40,243,56.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (70,41,269,13.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (71,41,42,23.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (72,42,41,23.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (73,42,43,20.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (74,43,42,201.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (75,43,230,32.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (76,43,236,14.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (77,44,45,45.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (78,44,46,37.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (79,44,47,27.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (80,44,49,24.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (81,44,234,25.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (82,44,236,7.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (83,45,46,14.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (84,45,52,31.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (85,45,37,34.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (86,46,47,24.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (87,46,44,37.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (88,46,45,14.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (89,47,48,25.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (90,48,49,15.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (91,48,217,23.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (92,48,50,13.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (93,49,48,15.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (94,49,44,24.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (95,50,48,13.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (96,50,51,12.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (97,50,270,6.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (98,51,50,12.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (99,51,52,63.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (100,52,51,63.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (101,52,53,10.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (102,52,45,31.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (103,53,52,10.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (104,53,54,21.0);");
        db.execSQL("INSERT INTO ARESTA VALUES (105,54,53,21.0);");
        db.execSQL("INSERT INTO LOCAL VALUES (1,'Bloco A',-10.1792264,-48.3611244,'Salas de aula',1);");
        db.execSQL("INSERT INTO LOCAL VALUES (2,'Bloco B',-10.1801134,-48.3605987,'Salas de aula',1);");
        db.execSQL("INSERT INTO LOCAL VALUES (3,'Bloco C',-10.1801028,-48.3616313,'Salas de aula',1);");
        db.execSQL("INSERT INTO LOCAL VALUES (4,'Bloco D / Anfiteatro',-10.1794956,-48.3616635,'Salas de aula',1);");
        db.execSQL("INSERT INTO LOCAL VALUES (5,'Bloco E',-10.177843,-48.3610949,'Salas de aula',1);");
        db.execSQL("INSERT INTO LOCAL VALUES (6,'Bloco F',-10.1779882,-48.3610815,'Salas de aula',1);");
        db.execSQL("INSERT INTO LOCAL VALUES (7,'Bloco G',-10.1767844,-48.3610788,'Salas de aula',1);");
        db.execSQL("INSERT INTO LOCAL VALUES (8,'Bloco H',-10.176032,-48.3618701,'Salas de aula',1);");
        db.execSQL("INSERT INTO LOCAL VALUES (9,'Bloco I',-10.1769137,-48.3601776,'Salas de aula',1);");
        db.execSQL("INSERT INTO LOCAL VALUES (10,'Bloco J',-10.1772701,-48.3601964,'Salas de aula',1);");
        db.execSQL("INSERT INTO LOCAL VALUES (11,'Bloco I',-10.1785241,-48.3616662,'Salas de aulas específicas para o Curso de Arquitetura e Urbanismo e Sindicato dos Técnicos Administrativo.',1);");
        db.execSQL("INSERT INTO LOCAL VALUES (12,'Bloco II',-10.1771276,-48.3618218,'Setor de Patrimônio, Salas de Professores, Sindicato dos Docentes, sala de reunião e Laboratórios de Ensino.',1);");
        db.execSQL("INSERT INTO LOCAL VALUES (13,'Bloco III',-10.1766946,-48.3618298,'Laboratórios de Informática, Salas dos PETs, Coordenações e salas de aula dos Mestrados e dois Auditórios.',1);");
        db.execSQL("INSERT INTO LOCAL VALUES (14,'Bloco IV',-10.1766972,-48.3622402,'Administração superior da UFT (Reitoria, Pró-Reitorias)',1);");
        db.execSQL("INSERT INTO LOCAL VALUES (15,'Bala I',-10.1781123,-48.3599147,'Secretária Acadêmica, Recursos Humanos do Campus de Palmas e etc.',1);");
        db.execSQL("INSERT INTO LOCAL VALUES (16,'Bala II',-10.178012,-48.3594695,'Direção do campus e coordenações de curso',1);");
        db.execSQL("INSERT INTO LOCAL VALUES (17,'Lanchonete',-10.1786561,-48.3613363,'Lanchonete',1);");
        db.execSQL("INSERT INTO LOCAL VALUES (18,'Restaurante Universitário',-10.1779143,-48.3585763,'RU do Campus de Palmas',1);");
        db.execSQL("INSERT INTO LOCAL VALUES (19,'Biblioteca',-10.1788647,-48.3619022,'Sala de leitura coletiva, sala de estudo com cabines para estudos individuais, sala com materiais especiais.',1);");
        db.execSQL("INSERT INTO LOCAL VALUES (20,'UMA – Universidade da Maturidade',-10.1788647,-48.3584207,'Universidade da Maturidade',1);");
        db.execSQL("INSERT INTO LOCAL VALUES (21,'Radio Universitária',-10.1783076,-48.3583,'Rádio Universitária – UFT FM 96,9',1);");
        db.execSQL("INSERT INTO LOCAL VALUES (22,'Restaurante Fazendinha',-10.1787538,-48.357144,'Restaurante fazendinha.',1);");
        db.execSQL("INSERT INTO LOCAL VALUES (23,'Lanchonete desativada',-10.176956,-48.3622241,'Lanchonete desativada atualmente.',1);");
        db.execSQL("INSERT INTO LOCAL VALUES (25,'CUICA – Auditório',-48.3611,-10.17746,'Auditório Central da UFT, com capacidade para 458 pessoas',1);");
        db.execSQL("INSERT INTO LOCAL VALUES (26,'Laboratório I',-10.1763197,-48.3611003,'Laboratórios específicos da área de saúde, onde são ministradas as aulas praticas.',1);");
        db.execSQL("INSERT INTO LOCAL VALUES (27,'Laboratório II',-10.1772886,-48.3613282,'Laboratórios específicos da área de saúde, onde são ministradas as aulas praticas.',1);");
        db.execSQL("INSERT INTO LOCAL VALUES (28,'Laboratório III',-10.1771381,-48.3602017,'Laboratórios específicos da área de saúde, onde são ministradas as aulas praticas.',1);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE TELEFONE;");
        db.execSQL("DROP TABLE LOCAL;");
        db.execSQL("DROP TABLE VERTICE;");
        db.execSQL("DROP TABLE ARESTA;");
        onCreate(db);
    }
}

