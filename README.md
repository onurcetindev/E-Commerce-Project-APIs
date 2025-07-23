# E-Commerce Project APIs

Bu proje, Java ve Spring Boot kullanılarak geliştirilmiş bir e-ticaret API uygulamasıdır. Geliştiricilere modern bir e-ticaret sisteminin temel bileşenlerini sunar ve genişletilebilir bir altyapı sağlar.

## Özellikler

- **Kullanıcı Yönetimi:** Kayıt olma, giriş yapma, rol bazlı erişim kontrolü
- **Ürün Yönetimi:** Ürün ekleme, güncelleme, silme, listeleme
- **Sipariş Yönetimi:** Sipariş oluşturma, sipariş takibi, sipariş durumu güncelleme
- **Sepet İşlemleri:** Sepete ürün ekleme, çıkarma, sepeti görüntüleme
- **Kategori Yönetimi:** Kategorileri ekleme, düzenleme, listeleme
- **Güvenlik:** JWT tabanlı kimlik doğrulama ve yetkilendirme
- **Dokümantasyon:** Swagger/OpenAPI ile API dokümantasyonu

## Kurulum

1. Depoyu klonlayın:
   ```bash
   git clone https://github.com/onurcetindev/E-Commerce-Project-APIs.git
   cd E-Commerce-Project-APIs
   ```

2. Gerekli Java sürümünün (Java 17+) yüklü olduğundan emin olun.

3. Bağımlılıkları yükleyin:
   ```bash
   ./mvnw clean install
   ```

4. Uygulamayı başlatın:
   ```bash
   ./mvnw spring-boot:run
   ```

## API Kullanımı

- Tüm uç noktalar `/api` ile başlar.
- Swagger arayüzünü kullanmak için: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Yapı

- `controller/` : API uç noktaları
- `service/` : İş mantığı
- `repository/` : Veri erişim katmanı
- `model/` : Veri modelleri ve varlıklar
- `config/` : Güvenlik ve genel yapılandırmalar

## Katkı Sağlama

Katkı sağlamak için pull request gönderebilir veya yeni bir issue oluşturabilirsiniz. Proje ile ilgili öneri ve geri bildirimlerinizi paylaşmak için GitHub Issues bölümünü kullanabilirsiniz.

## Lisans

Bu proje MIT lisansı ile lisanslanmıştır.

---

**Geliştirici:** [onurcetindev](https://github.com/onurcetindev)
