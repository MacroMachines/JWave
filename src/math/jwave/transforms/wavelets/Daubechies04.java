/**
 * JWave - Java implementation of wavelet transform algorithms
 *
 * Copyright 2008-2014 Christian Scheiblich
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at 
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 *
 * This file is part of JWave.
 *
 * @author Christian Scheiblich
 * date 23.02.2008 17:42:23
 * contact cscheiblich@gmail.com
 */
package math.jwave.transforms.wavelets;

/**
 * Ingrid Daubechies' orthonormal wavelet of eight coefficients and the scales;
 * normed, due to ||*||2 - euclidean norm.
 * 
 * @date 26.03.2010 07:35:31
 * @author Christian Scheiblich
 */
public class Daubechies04 extends Wavelet {

  /**
   * Already orthonormal coefficients taken from Filip Wasilewski's webpage
   * http://wavelets.pybytes.com/wavelet/db4/ Thanks!
   * 
   * @date 26.03.2010 07:35:31
   * @author Christian Scheiblich
   */
  public Daubechies04( ) {

    _transformWavelength = 2; // minimal wavelength of input signal

    _motherWavelength = 8; // wavelength of mother wavelet

    _scales = new double[ _motherWavelength ];
    _scales[ 0 ] = -0.010597401784997278;
    _scales[ 1 ] = 0.032883011666982945;
    _scales[ 2 ] = 0.030841381835986965;
    _scales[ 3 ] = -0.18703481171888114;
    _scales[ 4 ] = -0.02798376941698385;
    _scales[ 5 ] = 0.6308807679295904;
    _scales[ 6 ] = 0.7148465705525415;
    _scales[ 7 ] = 0.23037781330885523;

    // building wavelet as orthogonal (orthonormal) space from
    // scaling coefficients. Have a look into Alfred Haar's
    // wavelet for understanding what is done. ;-)
    _coeffs = new double[ _motherWavelength ];
    for( int i = 0; i < _motherWavelength; i++ )
      if( i % 2 == 0 )
        _coeffs[ i ] = _scales[ ( _motherWavelength - 1 ) - i ];
      else
        _coeffs[ i ] = -_scales[ ( _motherWavelength - 1 ) - i ];

  } // Daubechies04

} // class