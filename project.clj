(defproject dyntables "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :repositories [["artifactory" {:url "http://artifactory.yandex.net/artifactory/yandex_media_releases"}]]
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [jepsen "0.1.6"]
                 [org.clojure/data.json "0.2.6"]
                 [spootnik/unilog "0.7.21"]
                 [org.clojure/data.json "0.2.6"]
                 [ru.yandex/yt-java-ytclient "3163786"]
                 [com.ssmike/mvcc-checker "1.0-SNAPSHOT"]]
  :main jepsen.yt-kv
  :target-path "target/%s"
  :jvm-opts ["-Xmx10g"
             "-XX:+UseConcMarkSweepGC"
             "-XX:+UseParNewGC"
             "-XX:+CMSParallelRemarkEnabled"
             "-XX:+AggressiveOpts"
             "-XX:+UseFastAccessorMethods"
             "-XX:MaxInlineLevel=32"
             "-XX:MaxRecursiveInlineLevel=2"
             "-XX:+UnlockCommercialFeatures"
;             "-XX:-OmitStackTraceInFastThrow"
             "-server"]
  :plugins [[jonase/eastwood "0.2.4"]
            [lein-kibit "0.1.5"]]
  :omit-source true
  :test-selectors {:default (complement :fat)
                   :all (constantly true)}
  :profiles {:uberjar {:aot :all}})
