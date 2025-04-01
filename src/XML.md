# TestNG XML Dosyası Kullanımı

# ✅ TestNG `testng.xml` Dosyası: Etiketler ve Kullanımı

Bu doküman, TestNG framework’ü kullanarak XML dosyası üzerinden testleri nasıl kontrol edebileceğini, hangi etiketlerin kullanıldığını, alt etiketleri ve nasıl çalıştığını tüm detaylarıyla ama sade bir dille açıklar.

---

## 🗂️ Temel Yapı

```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
<suite name="TümSuite">
    <test name="TestSeti1">
        <classes>
            <class name="com.ornek.LoginTest">
                <methods>
                    <include name="pozitifLoginTesti" />
                    <exclude name="negatifLoginTesti" />
                </methods>
            </class>
        </classes>
    </test>
</suite>
```

---

## 🧩 Ana Etiketler ve Açıklamaları

### 🔹 `<suite>`
TestNG XML dosyasının en dış kapsayıcı etiketi.

- **name**: Suite’in adı (örneğin `SmokeTestSuite`)
- **paralel çalıştırma**, **thread-count** gibi ayarlar buraya yazılır.
- `<test>` etiketlerini içerir.

**Alt etiketler:**
- `<test>`
- `<parameter>`
- `<listeners>`

---

### 🔹 `<test>`
Bir test grubunu ifade eder. Genellikle bir test senaryosu ya da modül ile ilişkilidir.

- **name**: Test’in adı
- Farklı `class` ya da `group` tanımları bu etiketin içinde yapılır.

**Alt etiketler:**
- `<classes>`
- `<groups>`
- `<parameter>`

---

### 🔹 `<classes>`
Birden fazla sınıfı (`class`) tanımlamak için kapsayıcı etikettir.

**Alt etiket:**
- `<class>`

---

### 🔹 `<class>`
Test içeren Java sınıflarını belirtir.

- **name**: Sınıfın tam qualified adı (`com.ornek.DemoTest` gibi)

**Alt etiketler:**
- `<methods>`

---

### 🔹 `<methods>`
Sınıf içindeki hangi test metodlarının çalıştırılacağını belirtir.

**Alt etiketler:**
- `<include name="methodAdi"/>` → sadece bu metodu çalıştır.
- `<exclude name="methodAdi"/>` → bu metodu çalışma.

---

### 🔹 `<parameter>`
Test ya da suite seviyesinde parametre göndermek için kullanılır. Java kodunda `@Parameters` ile yakalanır.

```xml
<parameter name="browser" value="chrome"/>
```

Kod tarafında:

```java
@Parameters("browser")
public void setup(String browser) {
    // browser değişkeni burada kullanılabilir
}
```

---

### 🔹 `<groups>`
Belirli grupları çalıştırmak için kullanılır.

```xml
<groups>
    <run>
        <include name="smoke"/>
        <exclude name="regression"/>
    </run>
</groups>
```

Kodda:

```java
@Test(groups = {"smoke"})
public void test1() {}
```

---

### 🔹 `<listeners>`
TestNG listener sınıflarını eklemek için kullanılır.

```xml
<listeners>
    <listener class-name="utilities.ExtentReportListener"/>
</listeners>
```

---

## ⚙️ Parametre Kullanımı

Parametreler hem `suite` hem de `test` düzeyinde tanımlanabilir.

### Suite Düzeyi:
```xml
<suite name="MySuite">
    <parameter name="env" value="dev"/>
</suite>
```

Tüm testler bu parametreyi kullanabilir.

### Test Düzeyi:
```xml
<test name="LoginTest">
    <parameter name="username" value="admin"/>
</test>
```

Sadece bu test içindeki sınıflar ve metodlar kullanabilir.

---

## 🔁 Etiketler Arasındaki Hiyerarşi

```
<suite>
  └── <test>
        ├── <parameter>
        ├── <groups>
        ├── <classes>
        │     └── <class>
        │           └── <methods>
        │                 ├── <include>
        │                 └── <exclude>
        └── <listeners>
```

---

## 🧪 @Before ve @After Notasyonlarının XML'deki Bağlantısı

XML tarafı testlerin kontrolünü sağlar, ancak test yaşam döngüsünü Java tarafındaki notasyonlar belirler:

```java
@BeforeSuite      // <suite> başlamadan önce çalışır
@BeforeTest       // <test> başlamadan önce çalışır
@BeforeClass      // <class> başlamadan önce çalışır
@BeforeMethod     // her @Test metodundan önce çalışır
@Test             // test metodları
@AfterMethod      // her @Test metodundan sonra çalışır
@AfterClass       // <class> bittikten sonra çalışır
@AfterTest        // <test> bittikten sonra çalışır
@AfterSuite       // <suite> bittikten sonra çalışır
```

---

## 🎯 Örnek: Paralel Test Koşumu

```xml
<suite name="ParalelTestSuite" parallel="tests" thread-count="2">
    <test name="ChromeTest">
        <parameter name="browser" value="chrome"/>
        <classes>
            <class name="com.ornek.Test1"/>
        </classes>
    </test>
    <test name="FirefoxTest">
        <parameter name="browser" value="firefox"/>
        <classes>
            <class name="com.ornek.Test1"/>
        </classes>
    </test>
</suite>
```

---

## 📌 Notlar

- XML dosyası `testng.xml` olarak proje kök dizininde yer almalıdır.
- XML çalıştırmak için: Sağ tık → `Run testng.xml` ya da CI/CD sistemlerinde çağrılır.
- `methods` etiketi kullanılarak sadece istenen testler çalıştırılabilir.

---

