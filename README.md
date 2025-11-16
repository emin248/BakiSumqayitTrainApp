# Bakı-Sumqayıt Tren Uygulaması

Bakı-Sumqayıt tren seferleri için yerel (native) Android uygulaması. Web sitesi (https://www.baki-sumqayit.site/) arayüzünün birebir aynısı olarak tasarlanmıştır.

## Özellikler

- **Tren Arama:** Bakı-Sumqayıt-Pirşağı rotası için tren seferleri arayın
- **AdMob Entegrasyonu:** Her arama işleminde tam ekran geçişli reklam gösterilir
- **Material Design:** Modern ve kullanıcı dostu arayüz
- **Azerbaycan Dili:** Tamamen Azerbaycan dilinde arayüz
- **Responsive Tasarım:** Tüm ekran boyutlarında uyumlu

## Teknik Detaylar

### Kullanılan Teknolojiler

- **Dil:** Kotlin
- **Minimum SDK:** 24 (Android 7.0)
- **Target SDK:** 34 (Android 14)
- **Build System:** Gradle
- **UI Framework:** Android Material Design Components

### Kütüphaneler

- **AndroidX:** Core, AppCompat, ConstraintLayout
- **Google Play Services:** AdMob
- **Networking:** OkHttp, Gson
- **Async:** Kotlin Coroutines

## Proje Yapısı

```
BakiSumqayitTrainApp/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/bakisumqayit/trainapp/
│   │   │   │   ├── MainActivity.kt
│   │   │   │   ├── TrainResult.kt
│   │   │   │   ├── TrainResultsAdapter.kt
│   │   │   │   └── TrainApiClient.kt
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   ├── activity_main.xml
│   │   │   │   │   └── item_train_result.xml
│   │   │   │   ├── values/
│   │   │   │   │   ├── strings.xml
│   │   │   │   │   ├── colors.xml
│   │   │   │   │   └── styles.xml
│   │   │   │   └── drawable/
│   │   │   │       ├── button_background.xml
│   │   │   │       ├── spinner_background.xml
│   │   │   │       ├── info_background.xml
│   │   │   │       ├── ic_train.xml
│   │   │   │       └── ic_info.xml
│   │   │   └── AndroidManifest.xml
│   │   ├── test/
│   │   └── androidTest/
│   ├── build.gradle
│   └── proguard-rules.pro
├── gradle/
│   └── wrapper/
├── build.gradle
├── settings.gradle
└── README.md
```

## Kurulum ve Derleme

### Gereksinimler

- Android Studio 2023.1 veya daha yeni
- Java 11 veya daha yeni
- Android SDK 34

### Adımlar

1. Projeyi klonlayın:
```bash
git clone https://github.com/yourusername/BakiSumqayitTrainApp.git
cd BakiSumqayitTrainApp
```

2. Android Studio'da açın:
   - Android Studio'yu başlatın
   - "Open an Existing Project" seçin
   - Proje klasörünü seçin

3. Gradle Sync yapın:
   - Android Studio otomatik olarak Gradle sync yapacaktır
   - Eğer yapmazsa: Build → Clean Project → Build → Rebuild Project

4. Uygulamayı çalıştırın:
   - Bir emülatör başlatın veya fiziksel cihazı bağlayın
   - Run → Run 'app' seçin

## AdMob Yapılandırması

Uygulamayı yayınlamadan önce AdMob yapılandırması yapmanız gerekmektedir:

1. [Google AdMob](https://admob.google.com/) hesabı oluşturun
2. Uygulama ve reklam birimlerini ekleyin
3. `AndroidManifest.xml` dosyasında `com.google.android.gms.ads.APPLICATION_ID` değerini güncelleyin
4. `MainActivity.kt` dosyasında `AD_UNIT_ID` değerini güncelleyin

## Arama İşlevi

Kullanıcı arama düğmesine bastığında:

1. Seçilen tarihler doğrulanır
2. AdMob geçişli reklamı yüklenir ve gösterilir
3. Reklam kapatıldıktan sonra tren seferleri gösterilir
4. Sonuçlar RecyclerView'da listelenir

## API Entegrasyonu

Şu anda uygulama mock veriler kullanmaktadır. Gerçek API entegrasyonu için:

1. `TrainApiClient.kt` dosyasındaki `searchTrains()` metodunu güncelleyin
2. Web sitesinin API endpoint'ini tespit edin
3. Uygun HTTP istekleri gönderin

## Geliştirme

### Yeni Özellik Ekleme

1. Yeni bir branch oluşturun: `git checkout -b feature/yeni-ozellik`
2. Değişiklikleri yapın
3. Commit edin: `git commit -am 'Yeni özellik ekle'`
4. Branch'ı push edin: `git push origin feature/yeni-ozellik`
5. Pull Request oluşturun

### Hata Raporlama

Hata bulduğunuz takdirde, lütfen [Issues](../../issues) bölümünde bir rapor oluşturun.

## Lisans

Bu proje MIT Lisansı altında lisanslanmıştır. Detaylar için [LICENSE](LICENSE) dosyasına bakın.

## İletişim

Sorularınız veya önerileriniz için lütfen bir issue açın veya pull request gönderin.

## Teşekkürler

- Web sitesi tasarımı: https://www.baki-sumqayit.site/
- Material Design: Google
- AdMob: Google Play Services
