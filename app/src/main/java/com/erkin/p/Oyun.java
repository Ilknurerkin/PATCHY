package com.erkin.p;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;

public class Oyun extends AppCompatActivity {
    private TextView metinsoru, süre, puan;
    private String[] sorular;
    private String[][] cevaplar;
    private int[] cevap;
    private Button btn1, btn2, btn3, btn4,pas;
    private int  dogrusayisi = 0;
    private int clickKontrol, sn =60, sorukontrol = 0;
    private MediaPlayer dogrusesi, yanlıssesi, gerisayım;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun);
        metinsoru = (TextView) findViewById(R.id.metinsoru);
        süre = (TextView) findViewById(R.id.süre);
        puan = (TextView) findViewById(R.id.puan);
        btn1 = (Button) findViewById(R.id.A);
        btn2 = (Button) findViewById(R.id.B);
        btn3 = (Button) findViewById(R.id.C);
        btn4 = (Button) findViewById(R.id.D);
        pas= (Button) findViewById(R.id.pas);
        dogrusesi=MediaPlayer.create(Oyun.this,R.raw.dogru);
        yanlıssesi=MediaPlayer.create(Oyun.this,R.raw.yanlis);
        gerisayım= MediaPlayer.create(Oyun.this, R.raw.sure);
         sorular = new String[]{
                "2. Dünya Savaşı'ndan Nazi Toplama kampında hayatını kaybeden, ölümünden sonra 'Bir Genç Kızın Günlüğü'adıyla basılan anıları 65'den fazla dile çevrilen yazar kimdir?",
                "Rene Descartes ortaya attığı 'düşündüğü üstüne düşünebilen insan'tezini ve günümüz modern insan kavramını aşağıdakilerden hangisi karşılamakatadır",
                "Reggae müzik tarzının en önemli ismi olan Jamaika doğumlu müzisyen kimdir",
                "Sonunda büyük bir başarıya ulaşmak için yok olma tehlikesi bile göze alınır anlamında söylenen atasözümüz hangisidir.",
                "Demokrasi iki kurtla bir kuzunun öğle emeğinde ne yeneceğini oylamasıdır. Özgürlük ise tam teçhizatlı bir kuzunun oylamaya karşı çıkmasıdır sözü kime aittir?",
                "Sinekli Bakkal” Romanının Yazarı Aşağıdakilerden Hangisidir?",
                "1980'li yılların başında bulunan yüksek bir tepe, dağ veya yardan süzülme sonucu havalanan eksterm spor ve bu sporla aynı adı taşıyan hava aracı hangisidir.",
        };
        cevaplar = new String[][]{
                {"Anomne Frank", "Clara Barton", "Sylvia Plath", "Louisa May Alcott"},
                {"Homo erectus", "Homogeneous", "Homo sapiens", "Hominid"},
                {"Eric Clapton", "Leonard Cohen", "Ray Orbinson", "Bob Marley"},
                {"Ya devlet başa ya kuzgun leşe", "Su uyur düşman uyumaz", "Acele ile menzil alınmaz", "İki günü eşit olan zarardadır"},
                {"Benjamin Fraklin", "Tolstoy", "Faruk Nafiz Çamlıbel", "Trump"},
                {"Halide Edip Adıvar", "Reşat Nuri Güntekin", "Ziya Gökalp", "Şükrü Erbaş"},
                {"Yelken kanat", "Yamaç paraşütü", "Zeplin", "Planör"},
        };
        cevap = new int[]{1, 3, 4, 1, 1, 1, 2};

        //Geri Sayım
        new CountDownTimer(60000,1000) {
            public void onTick(long millisUntilFinished) {
                süre.setText(""+ millisUntilFinished/1000);
                sn--;
                if(sn==60){
                    gerisayım.start();
                }
//soru

                metinsoru.setText(sorular[sorukontrol]);
                btn1.setText(cevaplar[sorukontrol][0]);
                btn2.setText(cevaplar[sorukontrol][1]);
                btn3.setText(cevaplar[sorukontrol][2]);
                btn4.setText(cevaplar[sorukontrol][3]);
                //cevaplar
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (clickKontrol == 0) {
                            if (cevap[sorukontrol] == 1) {
                                dogrusayisi += 1;
                                btn1.setBackgroundColor(Color.parseColor("#ffffff"));
                                puan.setText("puanınız: " + 3 * dogrusayisi);
                               dogrusesi.start();
                            } else {
                                btn1.setBackgroundColor(Color.parseColor("red"));
                               yanlıssesi.start();
                            }
                            clickKontrol = 1;
                        }
                    }
                });
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (clickKontrol == 0) {
                            if (cevap[sorukontrol] == 2) {
                                dogrusayisi += 1;
                                btn2.setBackgroundColor(Color.parseColor("#ffffff"));
                                puan.setText("puanınız: " + 3 * dogrusayisi);
                                dogrusesi.start();
                            } else {
                                btn2.setBackgroundColor(Color.parseColor("red"));
                                yanlıssesi.start();
                            }
                            clickKontrol = 1;
                        }
                    }

                });
                btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (clickKontrol == 0) {
                            if (cevap[sorukontrol] == 3) {
                                dogrusayisi += 1;
                                btn3.setBackgroundColor(Color.parseColor("#fffff"));
                                puan.setText("puanınız: " + 3 * dogrusayisi);
                               dogrusesi.start();
                            } else {
                                btn3.setBackgroundColor(Color.parseColor("red"));
                                yanlıssesi.start();
                            }
                            clickKontrol = 1;
                        }
                    }
                });
                btn4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (clickKontrol == 0) {
                            if (cevap[sorukontrol] == 4) {
                                dogrusayisi += 1;
                                btn4.setBackgroundColor(Color.parseColor("#ffffff"));
                                puan.setText("puanınız: " + 3 * dogrusayisi);
                                dogrusesi.start();
                            } else {
                                btn4.setBackgroundColor(Color.parseColor("red"));
                               yanlıssesi.start();
                            }
                            clickKontrol = 1;
                        }
                    }
                });
                //cevap verilemezse
                pas.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (clickKontrol == 0) {
                            clickKontrol = 1;
                        }
                    }
                });
                // YENİ SORUYA GEÇMEK İÇİN
                if (clickKontrol == 1) {
                    sorukontrol += 1;
                    if (sorukontrol == 7) {
                        Intent i = new Intent(Oyun.this, MainActivity.class);
                        startActivity(i);
                        finish();
                    }
                    new android.os.Handler().postDelayed(new Runnable() {
                        public void run() {
                            clickKontrol = 0;
                            btn1.setBackgroundColor(Color.parseColor("#ff669900"));
                            btn2.setBackgroundColor(Color.parseColor("#ff669900"));
                            btn3.setBackgroundColor(Color.parseColor("#ff669900"));
                            btn4.setBackgroundColor(Color.parseColor("#ff669900"));
                        }
                    }, 500);
                }
            }
            public void onFinish(){
                Intent i = new Intent(Oyun.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        }.start();
    }
}