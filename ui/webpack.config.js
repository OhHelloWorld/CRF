const webpack = require('webpack');

const ExtractTextPlugin = require('extract-text-webpack-plugin');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const cssPlugin = new ExtractTextPlugin({
  filename: '[name].bundle.css',
});

module.exports = {

  entry: {
    vendor: [
      'jquery',
      'angular',
      'lodash'
    ],
    main: __dirname + '/src/entries/index.js',
    start: __dirname + '/src/entries/main.js'
  },
  output: {
    path: __dirname + '/dist',
    filename: '[name].bundle.js'
  },

  //split code
  module: {
    loaders: [{
      test: /\.js$/,
      exclude: /node_modules/,
      loaders: ['babel-loader']
    }, {
      test: /\.html$/,
      use: ['html-loader']
    }, {
      test: /\.css$/,
      use: cssPlugin.extract({
        use: 'css-loader',
        fallback: 'style-loader'
      }),
    }, {
      test: /\.(png)|(gif)|(jpg)$/,
      loader: 'url-loader?limit=50000'
    }, {
      test: /\.woff(2)?(\?v=[0-9]\.[0-9]\.[0-9])?$/,
      use: 'url-loader?limit=10000&mimetype=application/font-woff'
    }, {
      test: /\.(ttf|eot|svg)(\?v=[0-9]\.[0-9]\.[0-9])?$/,
      use: 'file-loader'
    }]
  },

  plugins: [



    new HtmlWebpackPlugin({
      chunks: ['vendor', 'index'],
      filename: __dirname + '/dist/index.html',
      template: './src/entries/index.html'
    }),
    new HtmlWebpackPlugin({
      chunks: ['vendor', 'start'],
      filename: __dirname + '/dist/main.html',
      template: './src/entries/main.html'
    }),
    new webpack.ProvidePlugin({
      $: 'jquery',
      jQuery: 'jquery',
      'window.jQuery': 'jquery',
      'window.jquery': 'jquery'
    }),
    
    new webpack.optimize.CommonsChunkPlugin({
      name: 'vendor',
      // minChunks: Infinity
    }),
    cssPlugin,
  ]
};
