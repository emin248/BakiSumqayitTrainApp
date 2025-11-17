# Katkı Kılavuzu

Bakı-Sumqayıt Tren Uygulamasına katkı sağladığınız için teşekkür ederiz! Bu belge, projeye nasıl katkı yapabileceğinizi açıklamaktadır.

## Başlamadan Önce

1. Projeyi fork edin
2. Forkunuzu klonlayın: `git clone https://github.com/yourusername/BakiSumqayitTrainApp.git`
3. Upstream remote'unu ekleyin: `git remote add upstream https://github.com/emin248/BakiSumqayitTrainApp.git`

## Yeni Özellik Ekleme

### Adım 1: Branch Oluşturun
```bash
git checkout -b feature/yeni-ozellik
```

### Adım 2: Kodunuzu Yazın
- Kotlin dilinde yazın
- Material Design prensiplerine uyun
- Yorum ekleyin ve kodu açık tutun

### Adım 3: Değişiklikleri Test Edin
- Emülatörde test edin
- Farklı ekran boyutlarında test edin
- AdMob reklamlarının düzgün çalıştığını doğrulayın

### Adım 4: Commit Edin
```bash
git commit -m "Açıklayıcı commit mesajı"
```

### Adım 5: Push Edin
```bash
git push origin feature/yeni-ozellik
```

### Adım 6: Pull Request Oluşturun
1. GitHub'da forkunuza gidin
2. "Compare & pull request" düğmesine tıklayın
3. Açıklayıcı bir başlık ve açıklama yazın
4. "Create pull request" düğmesine tıklayın

## Hata Raporlama

### Hata Bulduğunuz Takdirde
1. [Issues](../../issues) bölümüne gidin
2. "New issue" düğmesine tıklayın
3. Açıklayıcı bir başlık yazın
4. Aşağıdaki bilgileri sağlayın:
   - Hatanın açıklaması
   - Adımlar (nasıl tekrarlanır)
   - Beklenen davranış
   - Gerçek davranış
   - Cihaz bilgileri (model, Android sürümü)
   - Ekran görüntüsü veya video (varsa)

## Kod Standartları

### Kotlin Stil Kılavuzu
- Satır uzunluğu maksimum 120 karakter
- 4 boşluk girintisi kullanın
- Camel case kullanın (örn: `myVariable`)
- Constant'lar UPPER_SNAKE_CASE kullanın (örn: `MY_CONSTANT`)

### Yorum Yazma
```kotlin
// Kısa açıklama
val myVariable = 0

/**
 * Uzun açıklama için KDoc kullanın
 * @param param1 Parametrenin açıklaması
 * @return Dönüş değerinin açıklaması
 */
fun myFunction(param1: String): String {
    return param1
}
```

### Adlandırma Kuralları
- Fonksiyonlar: `performSearch()`, `loadInterstitialAd()`
- Sınıflar: `MainActivity`, `TrainResult`, `AdManager`
- Değişkenler: `fromDate`, `resultsAdapter`, `searchButton`

## Git Commit Mesajları

### Format
```
Başlık (50 karakter veya daha az)

Detaylı açıklama (72 karakter sınırı)
```

### Örnekler
- ✅ `Add AdManager for better ad handling`
- ✅ `Fix crash when selecting invalid date`
- ✅ `Improve UI to match website design`
- ❌ `fix bug` (çok kısa)
- ❌ `Updated the code to make it work better and added some new features` (çok uzun)

## Pull Request Süreci

1. **Review**: Kodunuz en az bir kişi tarafından incelenecek
2. **Değişiklikler**: Geri bildirim alırsanız gerekli değişiklikleri yapın
3. **Merge**: Onaylandıktan sonra PR merge edilecek

## Lisans

Bu projeye katkı sağlayarak, katkılarınızın MIT Lisansı altında lisanslanacağını kabul etmiş olursunuz.

## Sorular?

Sorularınız varsa, lütfen bir issue açın veya tartışma başlatın.

Katkılarınız için teşekkür ederiz! 🎉
