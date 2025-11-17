# AdMob Yapılandırması ve Kurulum Kılavuzu

Bu belge, Bakı-Sumqayıt Tren Uygulamasını AdMob reklamlarıyla yapılandırmak için gerekli adımları açıklamaktadır.

## 1. AdMob Hesabı Oluşturma

### Adım 1: Google AdMob'a Kaydolun
1. [Google AdMob](https://admob.google.com/) web sitesine gidin
2. Google hesabınızla oturum açın
3. "Başlayın" düğmesine tıklayın
4. Ülkenizi seçin ve koşulları kabul edin

### Adım 2: Uygulama Ekleyin
1. AdMob panosunda "Uygulamalar" bölümüne gidin
2. "Uygulama Ekle" düğmesine tıklayın
3. Platform olarak "Android" seçin
4. Uygulama adını girin: "Bakı-Sumqayıt Tren"
5. "Uygulama Oluştur" düğmesine tıklayın

### Adım 3: Uygulama ID'sini Alın
1. Yeni oluşturulan uygulama için "Uygulama ID"sini kopyalayın
2. Format: `ca-app-pub-xxxxxxxxxxxxxxxx~yyyyyyyyyy`

## 2. Geçişli Reklam Birimi Oluşturma

### Adım 1: Reklam Birimi Oluşturun
1. AdMob panosunda "Reklam Birimleri" bölümüne gidin
2. "Reklam Birimi Oluştur" düğmesine tıklayın
3. Platform olarak "Android" seçin
4. Reklam türü olarak "Geçişli" seçin
5. Reklam birimi adını girin: "Arama Geçişli Reklamı"
6. "Reklam Birimi Oluştur" düğmesine tıklayın

### Adım 2: Reklam Birimi ID'sini Alın
1. Yeni oluşturulan reklam birimi için ID'sini kopyalayın
2. Format: `ca-app-pub-3940256099942544/1033173712` (test) veya `ca-app-pub-xxxxxxxxxxxxxxxx/yyyyyyyyyy` (production)

## 3. Uygulamayı Yapılandırma

### Adım 1: AndroidManifest.xml'i Güncelleyin
1. `app/src/main/AndroidManifest.xml` dosyasını açın
2. Aşağıdaki satırı bulun:
   ```xml
   <meta-data
       android:name="com.google.android.gms.ads.APPLICATION_ID"
       android:value="ca-app-pub-xxxxxxxxxxxxxxxx~yyyyyyyyyy" />
   ```
3. `android:value` değerini AdMob'dan aldığınız Uygulama ID'si ile değiştirin

### Adım 2: MainActivity.kt'i Güncelleyin
1. `app/src/main/java/com/bakisumqayit/trainapp/MainActivity.kt` dosyasını açın
2. Aşağıdaki satırı bulun:
   ```kotlin
   private val AD_UNIT_ID = "ca-app-pub-3940256099942544/1033173712" // Test Ad Unit ID
   ```
3. `AD_UNIT_ID` değerini AdMob'dan aldığınız Reklam Birimi ID'si ile değiştirin

### Adım 3: AdManager.kt'i Güncelleyin
1. `app/src/main/java/com/bakisumqayit/trainapp/AdManager.kt` dosyasını açın
2. Aşağıdaki satırı bulun:
   ```kotlin
   private val AD_UNIT_ID = "ca-app-pub-3940256099942544/1033173712"
   ```
3. `AD_UNIT_ID` değerini AdMob'dan aldığınız Reklam Birimi ID'si ile değiştirin

## 4. Test Reklamları

### Geliştirme Sırasında Test Reklamları Kullanın
- **Test Uygulama ID**: `ca-app-pub-3940256099942544~3347511713`
- **Test Geçişli Reklam Birimi ID**: `ca-app-pub-3940256099942544/1033173712`

Bu test ID'leri kullanarak geliştirme ve test sırasında gerçek reklamlar gösterilmez.

### Cihazı Test Cihazı Olarak Kaydedin
1. Uygulamayı çalıştırın
2. Logcat'te "Use RequestConfiguration.Builder().setRequestConfiguration" mesajını arayın
3. Cihaz ID'sini kopyalayın
4. AdMob panosunda "Uygulamalar" → "Uygulama Ayarları" → "Test Cihazları"'na gidin
5. Cihaz ID'sini ekleyin

## 5. Üretim Dağıtımı

### Adım 1: Üretim ID'lerini Ayarlayın
1. Tüm test ID'lerini üretim ID'leriyle değiştirin
2. Kodda hiçbir test ID'si kalmadığından emin olun

### Adım 2: Uygulamayı İmzalayın
```bash
./gradlew assembleRelease
```

### Adım 3: Google Play Store'a Yükleyin
1. [Google Play Console](https://play.google.com/console) açın
2. Yeni uygulama oluşturun
3. İmzalı APK dosyasını yükleyin
4. Gerekli bilgileri doldurun ve yayınlayın

## 6. Sorun Giderme

### Reklamlar Gösterilmiyor
1. Test ID'lerini kullandığınızdan emin olun
2. Cihazı test cihazı olarak kaydettiğinizi doğrulayın
3. İnternet bağlantısını kontrol edin
4. AdMob panosunda reklam birimi durumunu kontrol edin

### Hata Mesajları
- **"Ad failed to load"**: Test ID'lerini kontrol edin veya internet bağlantısını doğrulayın
- **"Invalid Ad Unit ID"**: Reklam Birimi ID'sinin doğru olduğundan emin olun

## 7. Kaynaklar

- [Google AdMob Belgeleri](https://support.google.com/admob/)
- [Google Mobile Ads SDK for Android](https://developers.google.com/admob/android/quick-start)
- [AdMob Politikaları](https://support.google.com/admob/answer/6128543)

## İletişim

Sorularınız veya sorunlarınız için lütfen bir issue açın.
