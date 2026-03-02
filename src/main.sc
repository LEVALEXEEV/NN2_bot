require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /
    
    state: Start
        q!: $regex</start>
        a: Привет! Я бот-помощник. Могу рассказать о погоде или курсах валют. Спросите меня!
        
    state: hello
        intent!: /hello
        a: Привет! Рад вас видеть! Чем могу помочь? Я могу рассказать о погоде или курсах валют.
        intent: /hello || toState = "/hello"

    state: weather
        intent!: /weather
        a: Сегодня ожидается переменная облачность, температура около +5°C. Ветер слабый, осадков не предвидится. Хорошего дня!
        intent: /weather || toState = "/weather"

    state: currency
        intent!: /currency
        a: Актуальные курсы валют: USD — 90 руб., EUR — 98 руб., CNY — 12.5 руб. Данные актуальны на сегодня.
        intent: /currency || toState = "/currency"

    state: NoMatch
        event!: noMatch
        a: Извините, я не понял ваш запрос. Вы сказали: {{$request.query}}. Попробуйте спросить о погоде или курсах валют.
        event: noMatch || toState = "/NoMatch"