import tensorflow as tf
from tensorflow.keras import datasets, models, layers

def train_and_save_model():
    # load and preprocess data from mnist model
    (x_train, y_train), (x_test, y_test) = datasets.mnist.load_data()
    x_train, x_test = x_train.astype('float32') / 255.0, x_test.astype('float32') / 255.0

    # build model
    model = models.Sequential([
        layers.Flatten(input_shape=(28, 28)),
        layers.Dense(128, activation='relu'),
        layers.Dense(10)
    ])

    # compile model
    model.compile(optimizer='adam',
                  loss=tf.keras.losses.SparseCategoricalCrossentropy(from_logits=True),
                  metrics=['accuracy'])

    # train model
    model.fit(x_train, y_train, epochs=5, validation_data=(x_test, y_test))

    # save trained model
    model.save('../../../mnist_model')
    
if __name__ == '__main__':
    train_and_save_model()
