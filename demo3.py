from sklearn.feature_extraction.text import CountVectorizer
from sklearn.naive_bayes import MultinomialNB
from sklearn.metrics import accuracy_score

texts = [
    "I love this product",
    "This is an amazing item",
    "I hate this",
    "This is terrible",
    "I enjoy using this",
    "This is the worst"
]

labels = ["positive", "positive", "negative", "negative", "positive", "negative"]

vectorizer = CountVectorizer()
X = vectorizer.fit_transform(texts)

X_train = X[:4]
X_test = X[4:]
y_train = labels[:4]
y_test = labels[4:]

classifier = MultinomialNB()
classifier.fit(X_train, y_train)

y_pred = classifier.predict(X_test)

print("Accuracy:", accuracy_score(y_test, y_pred))
print("Predictions:", y_pred)

new_texts = ["I like this", "This is awful"]
new_vectors = vectorizer.transform(new_texts)
new_predictions = classifier.predict(new_vectors)
print("New Predictions:", new_predictions)
